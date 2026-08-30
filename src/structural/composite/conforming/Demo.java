package structural.composite.conforming;

public class Demo {
    public static void run() {
        Directory root = new Directory("root");
        root.add(new File("readme.txt", 2));
        Directory src = new Directory("src");
        src.add(new File("Main.java", 5));
        src.add(new File("Util.java", 3));
        root.add(src);

        System.out.println("Total size: " + root.getSizeKb() + "kb");
        System.out.println();
        System.out.println("No separate totalSizeKb() function -- root.getSizeKb() alone");
        System.out.println("handles the whole tree, because Directory asks each of its");
        System.out.println("children the same question a File answers directly.");
    }

    public static void main(String[] args) {
        run();
    }
}
