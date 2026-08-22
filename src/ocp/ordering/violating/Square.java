package ocp.ordering.violating;

public class Square extends Shape {
    private final double side;
    private final double topLeftX, topLeftY;

    public Square(double side, double topLeftX, double topLeftY) {
        this.side = side;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
    }

    @Override
    public void draw() {
        System.out.printf("Square   side=%.1f at (%.1f, %.1f)%n", side, topLeftX, topLeftY);
    }

    @Override
    public boolean precedes(Shape other) {
        // Squares never precede anything -- circles always go first.
        return false;
    }
}
