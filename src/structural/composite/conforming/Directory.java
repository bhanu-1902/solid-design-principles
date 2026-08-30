package structural.composite.conforming;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSizeKb() {
        int total = 0;
        for (FileSystemComponent child : children) {
            total += child.getSizeKb(); // works whether child is a File or another Directory
        }
        return total;
    }
}
