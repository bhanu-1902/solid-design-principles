package lsp.container.conforming;

// Mutable containers add add()/delete() on top of Container<T>.
// PersistentSet deliberately does NOT implement this -- see below.
public interface Set<T> extends Container<T> {
    void add(T t);
    void delete(T t);
}
