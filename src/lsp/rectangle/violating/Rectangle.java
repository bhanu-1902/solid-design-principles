package lsp.rectangle.violating;

public class Rectangle {
    private double width;
    private double height;

    // Postcondition: getWidth() == w, and getHeight() is UNCHANGED.
    public void setWidth(double w) {
        this.width = w;
    }

    // Postcondition: getHeight() == h, and getWidth() is UNCHANGED.
    public void setHeight(double h) {
        this.height = h;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
