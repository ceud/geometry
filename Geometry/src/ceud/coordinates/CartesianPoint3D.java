package ceud.coordinates;

/**
 * Represents a point in 3 dimensional space
 * 
 * @author Craig Allan
 * @version 29/Jan/2013
 */
public class CartesianPoint3D {
    private CartesianPoint2D point;
    private double z;

    public CartesianPoint3D(double X, double Y, double Z)
    {
        point.setX(X);
        point.setY(Y);
        z = Z;
    }

    public double getX()
    {
        return point.getX();
    }

    public double getY()
    {
        return point.getY();
    }

    public double getZ()
    {
        return z;
    }

    public void setX(double X)
    {
        point.setX(X);
    }

    public void setY(double Y)
    {
        point.setY(Y);
    }

    public void setZ(double Z)
    {
        z = Z;
    }

    /**
     * Calculates the distance between 2 3D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance between two points
     */
    public double distanceTo(CartesianPoint3D p)
    {
        return Math.sqrt(distanceToSquared(p));
    }

    /**
     * Calculates the distance squared between 2 3D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance squared between two points
     */
    public double distanceToSquared(CartesianPoint3D p)
    {
        return Math.pow((p.getX() - getX()), 2) + Math.pow((p.getY() - getY()), 2) + Math.pow((p.getZ() - z), 2);
    }

    public static CartesianPoint3D FromSpherical(double radius, double theta, double phi)
    {
        double x = radius * Math.sin(theta) * Math.cos(phi);
        double y = radius * Math.sin(theta) * Math.sin(phi);
        double z = radius * Math.cos(theta);
        return new CartesianPoint3D(x, y, z);
    }

    @Override
    public String toString()
    {
        return getX() + "," + getY() + "," + z;
    }
}
