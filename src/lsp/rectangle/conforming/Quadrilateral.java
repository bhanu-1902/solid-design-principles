package lsp.rectangle.conforming;

// A read-only capability every "shape with an area" can honestly
// support, no matter how its mutation rules differ.
public interface Quadrilateral {
    double getWidth();
    double getHeight();
    double area();
}
