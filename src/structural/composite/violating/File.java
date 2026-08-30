package structural.composite.violating;

public class File {
    private final String name;
    private final int sizeKb;

    public File(String name, int sizeKb) {
        this.name = name;
        this.sizeKb = sizeKb;
    }

    public String getName() {
        return name;
    }

    public int getSizeKb() {
        return sizeKb;
    }
}
