package structural.composite.conforming;

public class File implements FileSystemComponent {
    private final String name;
    private final int sizeKb;

    public File(String name, int sizeKb) {
        this.name = name;
        this.sizeKb = sizeKb;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSizeKb() {
        return sizeKb;
    }
}
