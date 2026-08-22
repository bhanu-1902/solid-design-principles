package lsp.container.conforming;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {
    private final HashSet<T> items = new HashSet<>();

    @Override
    public void add(T t) {
        items.add(t);
    }

    @Override
    public void delete(T t) {
        items.remove(t);
    }

    @Override
    public boolean isMember(T t) {
        return items.contains(t);
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}
