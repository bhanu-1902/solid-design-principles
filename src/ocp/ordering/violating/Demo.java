package ocp.ordering.violating;

import java.util.List;

public class Demo {
    public static void run() {
        List<Shape> shapes = List.of(
                new Square(3.0, 1.0, 1.0),
                new Circle(2.0, 0.0, 0.0)
        );
        System.out.println("Unordered input: Square, Circle");
        System.out.println("Drawn in order (circles-before-squares policy is baked into Circle & Square):");
        ShapeDrawer.drawAllShapesInOrder(shapes);
        System.out.println("Note: adding a Triangle means editing precedes() on BOTH Circle and Square.");
    }

    public static void main(String[] args) {
        run();
    }
}
