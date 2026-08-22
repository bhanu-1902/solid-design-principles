package ocp.ordering.conforming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDrawer {
    public static void drawAllShapesInOrder(List<Shape> shapes) {
        List<Shape> ordered = new ArrayList<>(shapes);
        Collections.sort(ordered);
        for (Shape s : ordered) {
            s.draw();
        }
    }
}
