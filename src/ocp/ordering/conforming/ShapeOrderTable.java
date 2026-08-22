package ocp.ordering.conforming;

import java.util.List;

// Listing 6: the ONE place that knows the drawing order.
// Neither Shape's subclasses nor ShapeDrawer need to change when
// this policy changes, or when a new Shape subtype is added.
public class ShapeOrderTable {
    private static final List<Class<? extends Shape>> ORDER = List.of(
            Circle.class,
            Square.class,
            Triangle.class
    );

    public static int orderOf(Class<? extends Shape> type) {
        int index = ORDER.indexOf(type);
        // Unlisted shapes sort first, matching the lookup behavior
        // from Martin's original table-driven comment.
        return index == -1 ? -1 : index;
    }
}
