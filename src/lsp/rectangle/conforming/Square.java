package lsp.rectangle.conforming;

// No longer extends Rectangle. A square IS-A rectangle geometrically,
// but a Square object is not behaviorally substitutable for a
// Rectangle object -- so per LSP it must not be a subtype of it. It
// only shares the read-only Quadrilateral capability.
public class Square implements Quadrilateral {
    private double side;

    public void setSide(double s) {
        this.side = s;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
