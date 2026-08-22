package ocp.rtti.conforming;

public class Circle extends Shape {
    private final double centerX, centerY, radius;

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("Circle   r=%.1f at (%.1f, %.1f)%n", radius, centerX, centerY);
    }
}
