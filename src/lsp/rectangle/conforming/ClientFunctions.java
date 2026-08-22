package lsp.rectangle.conforming;

public class ClientFunctions {
    // area() now only promises what EVERY Quadrilateral can honestly
    // deliver: reading width, height, and area. It no longer assumes
    // width and height can be set independently -- that was never a
    // property of "being a quadrilateral," only of Rectangle
    // specifically.
    public static double area(Quadrilateral q) {
        return q.area();
    }
}
