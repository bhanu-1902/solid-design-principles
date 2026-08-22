package lsp.container.conforming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// PersistentSet is a SIBLING of Set<T>, not a subtype of it -- it
// implements only the read/iterate capability they share
// (Container<PersistentObject>), plus its own type-safe
// add(PersistentObject). No cast, no ClassCastException possible:
// the compiler enforces the constraint, exactly as Martin's own
// LSP-compliant fix does.
public class PersistentSet implements Container<PersistentObject> {
    private final List<PersistentObject> items = new ArrayList<>();

    public void add(PersistentObject p) {
        items.add(p);
    }

    @Override
    public boolean isMember(PersistentObject p) {
        return items.contains(p);
    }

    @Override
    public Iterator<PersistentObject> iterator() {
        return items.iterator();
    }
}
