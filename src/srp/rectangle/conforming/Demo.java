package srp.rectangle.conforming;

public class Demo {
    public static void run() {
        GeometricRectangle r = new GeometricRectangle(4, 3);
        System.out.println("A computational-geometry client uses ONLY this:");
        System.out.println("area() = " + r.area());

        System.out.println("A graphical client additionally uses the renderer:");
        new RectangleRenderer().draw(r);

        System.out.println("Changing how rendering works now touches RectangleRenderer");
        System.out.println("only. GeometricRectangle, and every client that only computes");
        System.out.println("area, is completely unaffected.");
    }

    public static void main(String[] args) {
        run();
    }
}
