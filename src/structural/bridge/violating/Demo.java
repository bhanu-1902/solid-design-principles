package structural.bridge.violating;

// One class per (shape, color) pair: 2 shapes x 2 colors already needs 4
// classes. Adding a third color (Green) means writing GreenCircle AND
// GreenSquare -- every existing shape needs a new class per new color,
// and vice versa. That multiplicative growth is the OCP problem Bridge
// exists to fix: shape and color can't vary independently here.
public class Demo {
    public static void run() {
        new RedCircle().draw();
        new BlueCircle().draw();
        new RedSquare().draw();
        new BlueSquare().draw();

        System.out.println();
        System.out.println("Adding \"Green\" means writing GreenCircle AND GreenSquare --");
        System.out.println("shape and color are welded together in each class name.");
    }

    public static void main(String[] args) {
        run();
    }
}
