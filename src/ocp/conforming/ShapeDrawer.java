package ocp.conforming;

import java.util.List;

public class ShapeDrawer {
    // Listing 2: closed for modification -- this method never
    // changes, no matter how many Shape subtypes get added.
    public static void drawAllShapes(List<Shape> shapes) {
        for (Shape s : shapes) {
            s.draw();
        }
    }
}
