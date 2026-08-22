package ocp.ordering.violating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDrawer {
    // Listing 4: sort using the (badly closed) Precedes chain, then draw.
    public static void drawAllShapesInOrder(List<Shape> shapes) {
        List<Shape> ordered = new ArrayList<>(shapes);
        Collections.sort(ordered);
        for (Shape s : ordered) {
            s.draw();
        }
    }
}
