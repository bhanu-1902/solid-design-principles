package ocp.rtti.violating;

import java.util.List;

public class ShapeDrawer {
    // Listing 9: needs one more instanceof branch for every new
    // Shape subtype. THIS is the OCP violation -- not the use of
    // instanceof/dynamic_cast by itself.
    public static void drawAllShapes(List<Shape> shapes) {
        for (Shape s : shapes) {
            if (s instanceof Circle c) {
                drawCircle(c);
            } else if (s instanceof Square sq) {
                drawSquare(sq);
            }
        }
    }

    private static void drawCircle(Circle c) {
        System.out.printf("Circle   r=%.1f at (%.1f, %.1f)%n", c.radius, c.centerX, c.centerY);
    }

    private static void drawSquare(Square s) {
        System.out.printf("Square   side=%.1f at (%.1f, %.1f)%n", s.side, s.topLeftX, s.topLeftY);
    }
}
