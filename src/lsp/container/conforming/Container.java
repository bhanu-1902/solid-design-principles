package lsp.container.conforming;

// The capability EVERY container in this hierarchy can honestly
// share: you can iterate it and test membership.
public interface Container<T> extends Iterable<T> {
    boolean isMember(T t);
}
