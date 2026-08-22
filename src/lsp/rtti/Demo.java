package lsp.rtti;

import ocp.conforming.Circle;
import ocp.conforming.Square;
import ocp.conforming.Triangle;

public class Demo {
    public static void run() {
        System.out.println("ocp.conforming.Triangle already works fine through plain polymorphism");
        System.out.println("(ocp.conforming.ShapeDrawer just calls s.draw() -- see section 2 above).");
        System.out.println("Route the SAME three shapes through a typeid-style switch instead:");
        ShapeTypeSwitch.drawShape(new Circle(2.0, 0.0, 0.0));
        ShapeTypeSwitch.drawShape(new Square(3.0, 1.0, 1.0));
        ShapeTypeSwitch.drawShape(new Triangle(4.0, 2.0, 2.0, 2.0));
        System.out.println("(Triangle printed nothing above -- ShapeTypeSwitch doesn't know it");
        System.out.println(" exists. That's LSP being violated: code written against Shape");
        System.out.println(" cannot treat every Shape the same way without knowing its exact type.)");
    }

    public static void main(String[] args) {
        run();
    }
}
