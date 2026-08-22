package ocp.ordering.conforming;

import java.util.List;

public class Demo {
    public static void run() {
        List<Shape> shapes = List.of(
                new Square(3.0, 1.0, 1.0),
                new Triangle(4.0, 2.0, 2.0, 2.0),
                new Circle(2.0, 0.0, 0.0)
        );
        System.out.println("Unordered input: Square, Triangle, Circle");
        System.out.println("Drawn in order (per ShapeOrderTable -- Circle, Square, Triangle):");
        ShapeDrawer.drawAllShapesInOrder(shapes);
        System.out.println("Triangle was added with ONE new file + ONE line in ShapeOrderTable.");
        System.out.println("Circle, Square, and ShapeDrawer were never touched.");
    }

    public static void main(String[] args) {
        run();
    }
}
