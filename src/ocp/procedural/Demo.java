package ocp.procedural;

import java.util.List;

public class Demo {
    public static void run() {
        List<Shape> shapes = List.of(
                new Circle(2.0, 0.0, 0.0),
                new Square(3.0, 1.0, 1.0)
        );
        ShapeDrawer.drawAllShapes(shapes);
        System.out.println("Adding a Triangle means editing ShapeDrawer.drawAllShapes' switch --");
        System.out.println("and every other switch on ShapeType elsewhere in the app.");
    }

    public static void main(String[] args) {
        run();
    }
}
