package ceud.coordinates;

/**
 * Represents a point in 2 dimensional space
 * 
 * @author Craig Allan
 * @version 29/Jan/2013
 */
public class PolarPoint {
    private double radius, theta;

    public PolarPoint(double RADIUS, double THETA)
    {
        radius = RADIUS;
        theta = THETA;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getTheta()
    {
        return theta;
    }

    public void setRadius(double RADIUS)
    {
        radius = RADIUS;
    }

    public void setTheta(double THETA)
    {
        theta = THETA;
    }

    /**
     * Calculates the distance between 2 2D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance between two points
     */
    public double distanceTo(PolarPoint p)
    {
        return Math.sqrt(distanceToSquared(p));
    }

    /**
     * Calculates the distance squared between 2 2D points
     * 
     * @param  p   The point to which the distance should be calculated
     * @return     the distance squared between two points
     */
    public double distanceToSquared(PolarPoint p)
    {
        //return Math.pow((p.getX() - x), 2) + Math.pow((p.getY() - y), 2);
        //return (Math.pow(p.getRadius(), 2) + Math.pow(getRadius(), 2)) - (2 * p.getRadius() * getRadius() * Math.cos(p.getTheta() - getTheta()));
        double x1 = getRadius() * Math.cos(getTheta());
        double x2 = p.getRadius() * Math.cos(p.getTheta());
        double y1 = getRadius() * Math.sin(getTheta());
        double y2 = p.getRadius() * Math.sin(p.getTheta());
        return Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
    }

    public static PolarPoint FromCartesian(double x, double y)
    {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        double theta = Math.atan2(y, x);
        return new PolarPoint(radius, theta);
    }

    @Override
    public String toString()
    {
        return radius + "," + theta;
    }
/*
    public Point2D toPolar()
    {
        return new Point2D(this.distanceTo(new Point2D(0d, 0d)), this.polarAngle());
    }

    protected double polarAngle()
    {
        return Math.atan2(y, x);
    }
*/
}
