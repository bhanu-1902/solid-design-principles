package ocp.procedural;

import java.util.List;

public class ShapeDrawer {
    // Listing 1: switch on a type tag, then hand-cast.
    // A Triangle means adding a case HERE -- and everywhere else
    // in the codebase that has a switch just like it.
    public static void drawAllShapes(List<Shape> shapes) {
        for (Shape s : shapes) {
            switch (s.getType()) {
                case CIRCLE:
                    drawCircle((Circle) s);
                    break;
                case SQUARE:
                    drawSquare((Square) s);
                    break;
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
