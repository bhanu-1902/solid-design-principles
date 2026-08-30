package structural.flyweight.conforming;

import java.util.HashMap;
import java.util.Map;

// One centralized cache, the same shape as
// creational.prototype.conforming.CharacterFactory -- except this shares
// one instance across every caller instead of cloning a fresh one per
// call. Callers depend on TreeType, never construct one directly, and a
// species already seen is reused automatically on the next request.
public class TreeFactory {
    private final Map<String, TreeType> treeTypes = new HashMap<>();

    public TreeType getTreeType(String name, String color, String texture) {
        String key = name + ":" + color + ":" + texture;
        return treeTypes.computeIfAbsent(key, k -> {
            System.out.println("  (cache miss) creating shared TreeType for " + key);
            return new TreeType(name, color, texture);
        });
    }

    public int cachedTypeCount() {
        return treeTypes.size();
    }
}
