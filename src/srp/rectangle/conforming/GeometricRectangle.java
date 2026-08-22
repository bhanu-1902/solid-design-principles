package srp.rectangle.conforming;

// One reason to change: the mathematical model of a rectangle. This
// class has never heard of pixels, colors, or a GUI toolkit -- exactly
// Figure 9-2's split. Nothing here depends on rendering.
public class GeometricRectangle {
    private final double width;
    private final double height;

    public GeometricRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }
}
