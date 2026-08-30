package structural.flyweight.conforming;

public class Demo {
    public static void run() {
        Forest forest = new Forest();
        String oakTexture = "oak-bark-texture-data";
        for (int i = 0; i < 3; i++) {
            forest.plantTree("Oak", "Green", oakTexture, i * 10, 0);
        }
        forest.plantTree("Pine", "DarkGreen", "pine-bark-texture-data", 100, 0);

        forest.draw();
        System.out.println();
        System.out.println("Planted " + forest.treeCount() + " trees, but only " +
                forest.distinctTreeTypeCount() + " distinct TreeType objects were ever created --");
        System.out.println("every Oak shares the exact same TreeType instance.");
    }

    public static void main(String[] args) {
        run();
    }
}
