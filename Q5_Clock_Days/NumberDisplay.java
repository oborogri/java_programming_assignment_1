
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class NumberDisplay
{
    private int limit;
    private int value;

    /**
     * Constructor for objects of class NumberDisplay.
     * Set the limit at which the display rolls over.
     */
    public NumberDisplay(int limit)
    {
        this.limit = limit;
        value = 0;
    }

    /**
     * Returns the current value.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Returns the display value that is, the current value as a two-digit String. 
     * If the value is less than ten, it will be padded with a leading zero.
     */
    public String display()
    {
        if(value < 10) 
        {
            return "0" + value;
        }
        else {
            return Integer.toString(value);
        }
    }

    /**
     * Returns the display value that is, the current value as a three-digit String. 
     * If the value is less than ten, it will be padded with two leading zeros.
     * If the value is greater than ten but less than one hunderd, it will be padded with one leading zero. 
     */
    public String displayDays()
    {
        if(value < 10) 
        {
            return "00" + value;
        }

        if(value < 100)
        {
            return "0" + value;
        }
        else 
        {
            return Integer.toString(value);
        }
    }

    /**
     * Sets the value of the display to the new specified value. 
     * If the new value is less than zero or over the limit, do nothing.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * Increments the display value by one, rolling over to zero if the limit is reached.
     */
    public void incrementValue()
    {
        value = (value + 1) % limit;
    }

}
