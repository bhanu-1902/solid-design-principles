package lsp.container.violating;

// Implements Set<T> -- so any caller who only knows about Set<T>
// believes they can add() any T. Internally, though, add() unsafely
// assumes T really is a PersistentObject.
public class PersistentSet<T> implements Set<T> {
    private final ThirdPartyPersistentContainer delegate = new ThirdPartyPersistentContainer();

    @Override
    public void add(T t) {
        // Java's analogue of dynamic_cast<PersistentObject&>(t)
        // throwing bad_cast: an explicit cast that throws
        // ClassCastException at runtime if t isn't really one.
        PersistentObject p = (PersistentObject) t;
        delegate.add(p);
    }

    @Override
    public void delete(T t) {
        throw new UnsupportedOperationException("not needed for this demo");
    }

    @Override
    public boolean isMember(T t) {
        return delegate.items().contains(t);
    }
}
