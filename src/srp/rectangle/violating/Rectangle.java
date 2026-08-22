package srp.rectangle.violating;

// SRP violation (Figure 9-1): two unrelated reasons to change bundled
// into one class. A change to how rectangles are RENDERED (colors,
// pixels, a new GUI toolkit) and a change to the MATH of a rectangle
// (how area is defined) both land here, even though a computational-
// geometry client never calls draw() and a graphics client mostly
// doesn't care how area() is implemented.
public class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Reason to change #1: geometry / math.
    public double area() {
        return width * height;
    }

    // Reason to change #2: rendering.
    public void draw() {
        System.out.printf("Drawing %sx%s rectangle on screen%n", width, height);
    }
}
