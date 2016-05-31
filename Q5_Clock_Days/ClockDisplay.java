
/**
 * The ClockDisplay class implements a digital clock display for a 365 days/24 hour style clock.
 * The clock shows days, hours, minutes and seconds. 
 * The range of the clock is 000:00:00:00 (new year midnight) to 364:23:59:59 (one second before new year midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every second and reacts by incrementing the display. 
 * This is done in the usual clock fashion: the days, hours and mintes increment when their preceding display value rolls over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private NumberDisplay days;
    private String displayTime;    

    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 000:00:00:00
     */
    public ClockDisplay()
    {
        days = new NumberDisplay(365);
        hours  = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the parameters.
     */
    public ClockDisplay(int day, int hour, int minute, int second)
    {
        days = new NumberDisplay(365);
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(day, hour, minute, second);
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
     * Facilitates resetting the days on the clock
     * via setValue method in NumberDisplay class
     */
    public void resetDays(int value)
    {
        days.setValue(value);
        updateDisplay();
    }

    /**
     * This method should get called once every second - it makes
     * the clock display go one second forward, increment minutes, hours and days when the preceding dsiplay values are rolling to zero
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

        if((seconds.getValue() == 0) && (minutes.getValue() == 0) && (hours.getValue() == 0))
        {
            days.incrementValue();
        }
        updateDisplay();

    }

    /**
     * Sets the time of the display to the specified day, hour, minute and second vlaue
     */
    public void setTime(int day, int hour, int minute, int second)
    {
        days.setValue(day);
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        updateDisplay();
    }

    /**
     * Returns the current time of this display in the format DDD:HH:MM:SS
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
        displayTime = days.displayDays() + ":" + hours.display() + ":" + minutes.display() + ":" + seconds.display(); 
    }
}
