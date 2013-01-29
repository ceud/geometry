package ceud.coordinates;

/**
 * Represents a point in 3 dimensional space
 * 
 * @author Craig Allan
 * @version 29/Jan/2013
 */
public class SphericalPoint {
    private PolarPoint point;
    private double phi;

    public SphericalPoint(double RADIUS, double THETA, double PHI)
    {
        point.setRadius(RADIUS);
        point.setTheta(THETA);
        phi = PHI;
    }

    public double getRadius()
    {
        return point.getRadius();
    }

    public double getTheta()
    {
        return point.getTheta();
    }

    public double getPhi()
    {
        return phi;
    }

    public void setRadius(double RADIUS)
    {
        point.setRadius(RADIUS);
    }

    public void setTheta(double THETA)
    {
        point.setTheta(THETA);
    }

    public void setPhi(double PHI)
    {
        phi = PHI;
    }

    /**
     * Calculates the distance between 2 3D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance between two points
     */
    public double distanceTo(SphericalPoint p)
    {
        return Math.sqrt(distanceToSquared(p));
    }

    /**
     * Calculates the distance squared between 2 3D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance squared between two points
     */
    public double distanceToSquared(SphericalPoint p)
    {
        double x1 = getRadius() * Math.sin(getTheta()) * Math.cos(getPhi());
        double x2 = p.getRadius() * Math.sin(p.getTheta()) * Math.cos(p.getPhi());

        double y1 = getRadius() * Math.sin(getTheta()) * Math.sin(getPhi());
        double y2 = p.getRadius() * Math.sin(p.getTheta()) * Math.sin(p.getPhi());

        double z1 = getRadius() * Math.cos(getTheta());
        double z2 = p.getRadius() * Math.cos(p.getTheta());

        return Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2);
    }

    public static SphericalPoint FromCartesian(double x, double y, double z)
    {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        double theta = Math.acos(z / radius);
        double phi = Math.atan2(y, x);
        return new SphericalPoint(radius, theta, phi);
    }

    @Override
    public String toString()
    {
        return getRadius() + "," + getTheta() + "," + phi;
    }
/*
    public Point2D toPolar()
    {
        return new Point2D(this.distanceTo(new Point2D(0d, 0d)), this.polarAngle());
    }

    protected double polarAngle()
    {
        return Math.atan2(this.y, this.x);
    }
*/
}
