package ocp.rtti.conforming;

import java.util.List;

public class Demo {
    public static void run() {
        List<Shape> shapes = List.of(
                new Circle(0.0, 0.0, 2.0),
                new Square(1.0, 1.0, 3.0)
        );
        System.out.println("List has a Circle AND a Square, but we only want the squares:");
        SquareOnlyDrawer.drawSquaresOnly(shapes);
        System.out.println("This method never has to change, no matter how many other Shape kinds exist.");
    }

    public static void main(String[] args) {
        run();
    }
}
