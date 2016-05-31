import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class DemoArray 
 * @author Grigore Oboroceanu
 * @version 02.02.2016
 */
public class DemoArray 
{
    private int[] intArray;
    private int size = 10;

    /**
     * Creates new array intArray, of size 10   
     */
    public DemoArray() 
    {
        intArray = new int[size]; 
    }

    /**
     * Initializes each element of the array with 100 + i, using a for loop
     * Outputs the array
     */
    public void demoArray() 
    {
        for (int i = 0; i < intArray.length; i ++)
        {
            intArray [i] = 100 + i; 
            System.out.println("Element at index " + i + " is " + intArray [i]);
        }
    }

    /**
     * Initializes each element of the array with 200 + 2*i, using the while loop
     * Outputs the array
     */
    public void demoArray2() 
    {
        int i = 0;
        while (i < intArray.length)
        {
            intArray [i] = 200 + 2*i;
            System.out.println("Element at index " + i + " is " + intArray [i]);
            i ++;
        }
    }

    /**
     * Initializes each element of the array with 300 + 3*i, using a do-while loop
     * Outputs the array
     */
    public void demoArray3() 
    {
        int i = 0;
        do
        {
            intArray [i] = 300 + 3*i;
            System.out.println("Element at index " + i + " is " + intArray [i]);
            i ++;
        }  
        while (i < intArray.length);
    }

    /**
     * Creates an ArrayList of Integer and populates it using a for loop, sets elements at 400 + 4*i 
     * Uses an iterator to go through the arraylist and prints out all the elements
     */
    public void demoArray4() 
    {
        ArrayList<Integer>list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) 
        {
            list.add(400 + 4*i);
        }
        Iterator<Integer> it = list.iterator();
        int i = 0;
        while(it.hasNext())
        {
            System.out.println("Element at index " + i + " is " + it.next());
            i++;
        }
    }

    /**
     * Creates an array of even numbers in range [low, hi] with precondition: low and hi must be even. 
     * Calculates and prints out the sum of these numbers.
     */
    public void sumEven(int low, int hi)
    {

        if ((low % 2) != 0 || (hi % 2) !=0)
        {
            System.out.println("Please enter even arguments");
        }
        else
        {
            int evenSize = ((hi - low)/2 + 1);   
            int anArray[]= new int[evenSize]; 
            int index = 0;
            for (int i = low; i<= hi; i+=2)
            {
                anArray [index] = i;
                index ++;
            }  

            int sum = 0;
            index = 0;
            for (int i = low; i<= hi; i+=2)
            {
                sum = sum += anArray[index++];
            }
            System.out.println("Sum of even numbers from " + low + " to " + hi + " is: " + sum);
        }
    }
}