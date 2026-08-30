package structural.composite.conforming;

// The uniform abstraction: leaves (File) and composites (Directory)
// answer the same questions the same way. A client holding a
// FileSystemComponent never needs to know or care which one it has
// (DIP), and the recursion lives inside Directory itself instead of in
// every caller.
public interface FileSystemComponent {
    String getName();
    int getSizeKb();
}
