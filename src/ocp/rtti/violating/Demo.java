package ocp.rtti.violating;

import java.util.List;

public class Demo {
    public static void run() {
        List<Shape> shapes = List.of(
                new Circle(0.0, 0.0, 2.0),
                new Square(1.0, 1.0, 3.0)
        );
        ShapeDrawer.drawAllShapes(shapes);
        System.out.println("Adding a Triangle means adding another else-if branch here.");
    }

    public static void main(String[] args) {
        run();
    }
}
