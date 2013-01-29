package ceud.coordinates;

/**
 * Represents a point in 2 dimensional space
 * 
 * @author Craig Allan
 * @version 29/Jan/2013
 */
public class CartesianPoint2D {
    private double x, y;

    public CartesianPoint2D(double X, double Y)
    {
        x = X;
        y = Y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double X)
    {
        x = X;
    }

    public void setY(double Y)
    {
        y = Y;
    }

    /**
     * Calculates the distance between 2 2D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance between two points
     */
    public double distanceTo(CartesianPoint2D p)
    {
        return Math.sqrt(distanceToSquared(p));
    }

    /**
     * Calculates the distance squared between 2 2D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance squared between two points
     */
    public double distanceToSquared(CartesianPoint2D p)
    {
        return Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2);
    }

    public static CartesianPoint2D FromPolar(double radius, double theta)
    {
        double x = radius * Math.cos(theta);
        double y = radius * Math.sin(theta);
        return new CartesianPoint2D(x, y);
    }

    @Override
    public String toString()
    {
        return x + "," + y;
    }
}
