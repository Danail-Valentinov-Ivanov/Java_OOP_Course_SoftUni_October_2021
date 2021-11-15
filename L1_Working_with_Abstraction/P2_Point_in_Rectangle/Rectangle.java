package L1_Working_with_Abstraction.P2_Point_in_Rectangle;

public class Rectangle {
    private Point pointA;
    private Point pointB;

    public Rectangle(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public boolean isInside(Point pointForCheck) {
        return (pointA.getX() <= pointForCheck.getX() && pointA.getY() <= pointForCheck.getY())
                && (pointB.getX() >= pointForCheck.getX() && pointB.getY() >= pointForCheck.getY());
    }
}
