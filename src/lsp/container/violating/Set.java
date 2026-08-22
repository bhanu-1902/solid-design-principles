package lsp.container.violating;

public interface Set<T> {
    void add(T t);
    void delete(T t);
    boolean isMember(T t);
}
