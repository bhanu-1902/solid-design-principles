package lsp.container.violating;

import java.util.ArrayList;
import java.util.List;

// Stands in for Martin's non-generic third-party persistent
// container: by construction, it only ever accepts PersistentObject.
class ThirdPartyPersistentContainer {
    private final List<PersistentObject> items = new ArrayList<>();

    void add(PersistentObject p) {
        items.add(p);
    }

    List<PersistentObject> items() {
        return items;
    }
}
