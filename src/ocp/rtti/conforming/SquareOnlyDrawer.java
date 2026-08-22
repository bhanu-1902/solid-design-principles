package ocp.rtti.conforming;

import java.util.List;

public class SquareOnlyDrawer {
    // Listing 10: still uses instanceof, but only ever asks "is this
    // specifically a Square?" Adding Triangle, Pentagon, etc. never
    // requires touching this method -- so it does NOT violate OCP.
    public static void drawSquaresOnly(List<Shape> shapes) {
        for (Shape s : shapes) {
            if (s instanceof Square sq) {
                sq.draw();
            }
        }
    }
}
