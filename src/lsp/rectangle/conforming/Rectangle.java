package lsp.rectangle.conforming;

public class Rectangle implements Quadrilateral {
    private double width;
    private double height;

    public void setWidth(double w) {
        this.width = w;
    }

    public void setHeight(double h) {
        this.height = h;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
