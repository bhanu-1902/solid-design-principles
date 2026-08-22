package srp.rectangle.violating;

public class Demo {
    public static void run() {
        Rectangle r = new Rectangle(4, 3);
        System.out.println("area() = " + r.area() + "   (computational-geometry client)");
        r.draw();
        System.out.println("A GraphicalApplication change to HOW draw() renders forces a");
        System.out.println("rebuild of Rectangle -- and therefore of every computational-");
        System.out.println("geometry client too, even though it never calls draw().");
    }

    public static void main(String[] args) {
        run();
    }
}
