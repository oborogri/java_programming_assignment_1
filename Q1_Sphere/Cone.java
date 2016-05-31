/**
 * @file    Cone.java
 * @brief   This class describes a right circular cone and includes 
 *                  methods to calculate properties such as surface area and volume.
 * @version 1.0 April 1, 2014
 * @author  jfitzgerald
 */
public class Cone
{
    double height;
    Circle base;
    
    /**
     * Constructs a new Cone object defined by user-supplied parameters
     * @param height    The height of the right circular cone
     * @param base      A reference to Circle object defining base of right circular cone
     */
    public Cone(double height, Circle base)
    {
        this.height = height;
        this.base   = base;
    }
    
    /**
     * Calculates the volume of right circular cone object
     * @return The volume of right circular cone
     */
    public double volume()
    {
        double diameter = base.getDiameter();
        return Math.PI*diameter*diameter*height/12;
    }
    
    /**
     * Calculates the surface area of right circular cone (including base).
     * @return The total surface area right circular cone (includes base)
     */
    public double sufaceArea()
    {
        double radius       = base.getDiameter()/2.0;
        double slantHeight  = Math.hypot(radius, height);
        double areaTop      = Math.PI*radius*slantHeight;
        double areaBase     = base.area();
        return areaTop + areaBase;
    }
}

/**
 * A placeholder class, referenced by Cone, to allow Cone to compile
 */
class Circle
{
    public double area() {return 0;}
    public double getDiameter() {return 0;}
}