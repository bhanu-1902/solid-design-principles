package ocp.conforming;

// Added after the fact -- exactly Martin's point. This is the ONLY
// new file. Shape, Circle, Square, and ShapeDrawer are all untouched.
public class Triangle extends Shape {
    private final double base, height;
    private final double topLeftX, topLeftY;

    public Triangle(double base, double height, double topLeftX, double topLeftY) {
        this.base = base;
        this.height = height;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
    }

    @Override
    public void draw() {
        System.out.printf("Triangle base=%.1f height=%.1f at (%.1f, %.1f)%n", base, height, topLeftX, topLeftY);
    }
}
