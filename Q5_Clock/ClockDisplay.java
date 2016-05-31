
/**
 * The ClockDisplay class implements a digital clock display for a European-style 24 hour clock. 
 * The clock shows hours, minutes and seconds.
 * The range of the clock is 00:00:00 (midnight) to 23:59:59 (one second before midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every second and reacts by incrementing the display. 
 * This is done in the usual clock fashion: the hour increments when the minutes roll over to zero and minutes increment when seconds roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String displayTime;    

    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00:00
     */
    public ClockDisplay()
    {
        hours   = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects
     * This constructor creates a new clock set at the time specified by the parameters
     */
    public ClockDisplay(int hour, int minute, int second)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(hour, minute, second);
    }

    /**
     * Facilitates resetting the seconds on the clock
     * via setValue method in NumberDisplay class
     */
    public void resetSeconds(int value)
    {
        seconds.setValue(value);
        updateDisplay();
    }

    /**
     * Facilitates resetting the minutes on the clock
     * via setValue method in NumberDisplay class
     */
    public void resetMinutes(int value)
    {
        minutes.setValue(value);
        updateDisplay();
    }

    /**
     * Facilitates resetting the hours on the clock
     * via setValue method in NumberDisplay class
     */
    public void resetHours(int value)
    {
        hours.setValue(value);
        updateDisplay();
    }

    /**
     * This method should get called once every second - it makes 
     * the clock display go one second forward, increment the minutes when seconds roll over to zero and same principle applies to hours 
     */
    public void timeTick()
    {
        seconds.incrementValue();
        if(seconds.getValue() == 0)
        {
            minutes.incrementValue();
        }
        updateDisplay();

        if((seconds.getValue() == 0) && (minutes.getValue() == 0)) 
        {  
            hours.incrementValue();
        }
        updateDisplay();
    }

    /**
     * Sets the time of the display to the specified hour, minute and second value
     */
    public void setTime(int hour, int minute, int second)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }

    /**
     * Returns the current time of this display in the format HH:MM:SS
     */
    public String getTime()
    {
        return displayTime; 
    }

    /**
     * Updates the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayTime = hours.display() + ":" + minutes.display() + ":" + seconds.display(); 
    }
}
