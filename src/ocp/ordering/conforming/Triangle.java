package ocp.ordering.conforming;

// Added AFTER the fact to prove the point: this is the only new file
// needed, plus one line in ShapeOrderTable. Neither Shape,
// ShapeDrawer, Circle, nor Square had to change.
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
