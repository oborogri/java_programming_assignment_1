
/**
 * This is a class for creating Sphere objects, adjusting and calculating its states  
 * 
 * @author Grigore Oboroceanu 
 * @version 02.02.2016
 */
public class Sphere
{
    double radius;
    static int numberSpheres;

    /**
     * Constructs a new Sphere object with default value of radius
     * Counts the number of sphere objects created
     */
    public Sphere ()
    {
        radius = 10.0;
        numberSpheres ++;
    }

    /**
     * Constructs a new Sphere object defined by user-supplied parameters which should be positive only
     * Counts the number of sphere objects created 
     */
    public Sphere(double radius)
    {
        if (isValid(radius))
        {
            setState(radius);
            numberSpheres ++;
        }
        else
        { 
            System.out.println("You have attempted to create a sphere with a negative radius");
            System.out.println("Only positive radius permitted");
        }
    }

    /**
     * Calculates the surphase area of the Sphere object
     */
    public double surfaceArea()
    {
        return 4*Math.PI*radius*radius;
    }

    /**
     * Calculates the volume of the Sphere object
     */
    public double volume()
    {
        return 4*Math.PI*radius*radius*radius/3;
    }

    /**
     * Calculates the circumference of great circle for Sphere object
     */
    public double greatCircle() 
    {
        return 2*Math.PI*radius;
    }

    /** 
     * Facilitates changing the radius of Sphere object    
     * via setState method
     */
    public void changeSize(double radius)
    {
        setState(radius);
    }

    /** Facilitates adjusting the state of Sphere object  
     *  Checks that inputted value for radius is valid  
     */
    private void setState(double radius)
    { if (isValid(radius))
        {
            this.radius = radius;
        }
        else
        {
            System.out.println("Please insert a valid value");
        }
    }

    /**
     * Returns the number of Sphere objects created 
     */
    public int getNumberSpheres()
    {
        return numberSpheres;
    }

    /**
     * Checks that inputted radius value is valid
     */
    private boolean isValid(double radius)
    {
        return radius > 0; 
    } 
}
