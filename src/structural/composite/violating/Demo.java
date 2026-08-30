package structural.composite.violating;

// This method has to know that a Directory is really "files +
// subdirectories" and recurse manually. A third component type (e.g. a
// SymbolicLink) means editing this method to add a third case (violates
// OCP), and it only works by reaching into Directory's internal structure
// instead of asking a File/Directory the same question the same way.
public class Demo {
    static int totalSizeKb(Directory directory) {
        int total = 0;
        for (File file : directory.getFiles()) {
            total += file.getSizeKb();
        }
        for (Directory subdirectory : directory.getSubdirectories()) {
            total += totalSizeKb(subdirectory);
        }
        return total;
    }

    public static void run() {
        Directory root = new Directory("root");
        root.addFile(new File("readme.txt", 2));
        Directory src = new Directory("src");
        src.addFile(new File("Main.java", 5));
        src.addFile(new File("Util.java", 3));
        root.addSubdirectory(src);

        System.out.println("Total size: " + totalSizeKb(root) + "kb");
        System.out.println();
        System.out.println("totalSizeKb() has to know Directory is files+subdirectories and");
        System.out.println("recurse by hand. A new component kind means a new case here.");
    }

    public static void main(String[] args) {
        run();
    }
}
