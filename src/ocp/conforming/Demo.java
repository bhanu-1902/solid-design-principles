package ocp.conforming;

import java.util.List;

public class Demo {
    public static void run() {
        List<Shape> shapes = List.of(
                new Circle(2.0, 0.0, 0.0),
                new Square(3.0, 1.0, 1.0),
                new Triangle(4.0, 2.0, 2.0, 2.0)
        );
        ShapeDrawer.drawAllShapes(shapes);
        System.out.println("Triangle is new. ShapeDrawer.drawAllShapes was not modified to support it.");
    }

    public static void main(String[] args) {
        run();
    }
}
