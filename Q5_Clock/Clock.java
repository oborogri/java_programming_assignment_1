import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A very simple GUI (graphical user interface) for the clock display.
 *  
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Clock
{
    private JFrame frame;
    private JLabel label;
    private ClockDisplay clock;
    private boolean clockRunning = false;
    private TimerThread timerThread;

    /**
     * Constructor for objects of class Clock
     */
    public Clock()
    {
        makeFrame();
        clock = new ClockDisplay();
    }

    /**
     * Starts running the clock
     */
    private void start()
    {
        clockRunning = true;
        timerThread = new TimerThread();
        timerThread.start();
    }

    /**
     * Stops the clock running 
     */
    private void stop()
    {
        clockRunning = false;
    }

    /**
     * Increments the time on the clock with equal intervals 
     */
    private void step()
    {
        clock.timeTick();
        label.setText(clock.getTime());
    }

    /**
     * 'About' function: show the 'about' box.
     */
    private void showAbout()
    {
        JOptionPane.showMessageDialog (frame, 
            "Clock Version 1.0\n" +
            "A simple interface for the 'Objects First' clock display project",
            "About Clock", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }

    /**
     * Facilitates resetting the seconds on the clock
     * via resetSeconds method in clockDisplay class
     */
    public void resetSeconds(int value)
    {
        clock.resetSeconds(value);
    }

    /**
     * Facilitates resetting the minutes on the clock
     * via resetMinutes method in clockDisplay class
     */
    public void resetMinutes(int value)
    {
        clock.resetMinutes(value);
    }

    /**
     * Facilitates resetting the hours on the clock
     * via resetHours method in clockDisplay class
     */
    public void resetHours(int value)
    {
        clock.resetHours(value);
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {
        frame = new JFrame("Clock (Hours : Minutes : Seconds)");
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 90, 1, 90));

        makeMenuBar(frame);

        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(12, 12));

        // Create the image pane in the center
        label = new JLabel("00:00:00", SwingConstants.CENTER);
        Font displayFont = label.getFont().deriveFont(96.0f);
        label.setFont(displayFont);
        //imagePanel.setBorder(new EtchedBorder());
        contentPane.add(label, BorderLayout.CENTER);

        // Create the toolbar with the buttons
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1, 0));

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { start(); }
            });
        toolbar.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { stop(); }
            });
        toolbar.add(stopButton);

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { step(); }
            });
        toolbar.add(stepButton);

        // Add toolbar into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(toolbar);

        contentPane.add(flow, BorderLayout.SOUTH);

        // building is done - arrange the components      
        frame.pack();

        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     * 
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item;

        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);

        item = new JMenuItem("About Clock...");
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { showAbout(); }
            });
        menu.add(item);

        menu.addSeparator();

        item = new JMenuItem("Quit");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) { quit(); }
            });
        menu.add(item);
    }

    class TimerThread extends Thread
    {
        public void run()
        {
            while (clockRunning) {
                step();
                pause();
            }
        }

        private void pause()
        {
            try {
                Thread.sleep(300);   // pause for 300 milliseconds
            }
            catch (InterruptedException exc) {
            }
        }
    }
}