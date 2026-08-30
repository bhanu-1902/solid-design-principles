package structural.flyweight.violating;

public class Demo {
    public static void run() {
        Forest forest = new Forest();
        String oakTexture = "oak-bark-texture-data";
        for (int i = 0; i < 3; i++) {
            forest.plantTree("Oak", "Green", oakTexture, i * 10, 0);
        }

        forest.draw();
        System.out.println();
        System.out.println("Planted " + forest.treeCount() + " oaks, and every single one carries");
        System.out.println("its own separate copy of the identical name/color/texture --");
        System.out.println("nothing is shared between them.");
    }

    public static void main(String[] args) {
        run();
    }
}
