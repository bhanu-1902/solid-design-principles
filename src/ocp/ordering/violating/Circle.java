package ocp.ordering.violating;

public class Circle extends Shape {
    private final double radius;
    private final double centerX, centerY;

    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    @Override
    public void draw() {
        System.out.printf("Circle   r=%.1f at (%.1f, %.1f)%n", radius, centerX, centerY);
    }

    // Listing 5: hard-codes knowledge that Square exists.
    // A new Shape subtype means editing this method.
    @Override
    public boolean precedes(Shape other) {
        return other instanceof Square;
    }
}
