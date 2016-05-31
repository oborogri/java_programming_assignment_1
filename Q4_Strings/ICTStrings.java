public class ICTStrings
{
    String string;

    /**
     * Checks if s1 is equal to s2
     * @returns true if strings equal else false
     */
    public static boolean isEqual(String s1, String s2)
    {
        return (s1.equals (s2));
    }

    /**
     * Checks if s1 is equal to s2 ignoring case
     * @returns true if strings equal, ignoring case, else false
     */
    public static boolean isEqualIgnoreCase(String s1, String s2)
    {
        return (s1.equalsIgnoreCase(s2));
    }

    /**
     * Checks if s1 has prefix
     * @returns true if s1 has prefix, else false
     */
    public static boolean hasPrefix(String s1, String prefix)
    {
        return (s1.startsWith(prefix));
    }

    /**
     * Calculates Length of string comprising concatenated strings s1 and s2
     * @returns length of s1 concatenated with s2
     */
    public static int length(String s1, String s2)
    {
        return (s1 + s2).length(); 
    }

    /**
     * Creates string the uppercase version of s1
     * @returns copy of s1 all in upper case
     */
    public static String toUpper(String s1)
    {
        return s1.toUpperCase();
    }

    /**
     * Returns true if string ends with suffix.
     */
    public static boolean endsWith(String s1, String suffix)
    {
        return (s1.endsWith(suffix));
    }

    /**
     * Creates a substring of s1 from indexStart to indexEnd 
     * @returns the substring
     */
    public static String subString(String s1, int indexStart, int indexEnd)
    {
        return s1.substring(indexStart, indexEnd);
    }

    /**
     * Creates a string, the reverse of given string using StringBuilder
     * @returns a copy of given string reversed
     */
    public static String reverse_1(String string)
    {
        int i, len = string.length();
        StringBuilder dest = new StringBuilder(len);
        for (i = (len - 1); i >= 0; i--)
        {
            dest.append(string.charAt(i));
        }
        return dest.toString();
    }

    /**
     * Creates a string which is the reverse of given string
     * Uses an array of char type which is populated with the string in reverse order
     * Returns the string reversed
     */
    public static String reverse_2(String string)
    {
        char[] array = new char[string.length()];

        for(int i = array.length - 1, j = 0; i >= 0; i--, j++) 
        {
            array[i] = string.charAt(j);
        }
        return new String(array);
    }

    /**
     * Creates a reverse string using a StringBuffer class
     * Returns a copy of string reversed
     */
    public static String reverse_3(String string)
    {   
        StringBuffer buffer = new StringBuffer(string);
        buffer.reverse();      

        return buffer.toString(); 
    }

    /** 
     * Checks if string is a palindrom 
     * @return true if argument is a palindrome, else false.
     */
    public static boolean isPalindrome(String s)
    {
        if(s.length() == 0 || s.length() == 1)
        {
            return true;
        }

        if(s.charAt(0) == s.charAt(s.length()-1))
        {
            return isPalindrome(s.substring(1, s.length()-1));
        }
        return false;
    }

}
