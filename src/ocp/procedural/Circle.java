package ocp.procedural;

public class Circle implements Shape {
    public final double radius;
    public final double centerX, centerY;

    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.CIRCLE;
    }
}
