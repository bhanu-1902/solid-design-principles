package structural.composite.violating;

import java.util.ArrayList;
import java.util.List;

// Files and subdirectories are kept in separate lists, so any client that
// wants a directory's total size has to know this internal split and
// handle both kinds of children explicitly.
public class Directory {
    private final String name;
    private final List<File> files = new ArrayList<>();
    private final List<Directory> subdirectories = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addSubdirectory(Directory directory) {
        subdirectories.add(directory);
    }

    public List<File> getFiles() {
        return files;
    }

    public List<Directory> getSubdirectories() {
        return subdirectories;
    }
}
