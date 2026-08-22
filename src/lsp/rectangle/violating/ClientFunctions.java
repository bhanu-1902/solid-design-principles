package lsp.rectangle.violating;

public class ClientFunctions {
    // Martin's `f`: sets width, reasonably relies on Rectangle's
    // documented postcondition that height is left alone.
    public static void f(Rectangle r) {
        r.setWidth(32);
    }

    // Martin's `g`: written and tested only against Rectangle, and
    // relying on width and height varying independently. This is
    // exactly the kind of code the Open-Closed principle promises we
    // can reuse, UNMODIFIED, against every subtype of Rectangle.
    public static void g(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        double area = r.getWidth() * r.getHeight();
        if (area != 20) {
            throw new AssertionError(
                    "expected area 20, got " + area + " -- g() assumed width/height vary independently");
        }
    }
}
