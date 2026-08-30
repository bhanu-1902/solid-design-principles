package structural.bridge.conforming;

public class Demo {
    public static void run() {
        new Circle(new Red()).draw();
        new Circle(new Blue()).draw();
        new Square(new Red()).draw();
        new Square(new Blue()).draw();

        System.out.println();
        System.out.println("Circle and Square never named Red or Blue directly. A new Green");
        System.out.println("color is one new class, usable with both shapes immediately --");
        System.out.println("no GreenCircle or GreenSquare needed.");
    }

    public static void main(String[] args) {
        run();
    }
}
