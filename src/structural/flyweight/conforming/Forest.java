package structural.flyweight.conforming;

import java.util.ArrayList;
import java.util.List;

// Forest owns its TreeFactory outright (created here, no life outside
// this class) -- Composition -- while each Tree only references a shared
// TreeType it doesn't own -- Aggregation. Same package, two different
// relationship strengths.
public class Forest {
    private final TreeFactory treeFactory = new TreeFactory();
    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(String name, String color, String texture, int x, int y) {
        TreeType type = treeFactory.getTreeType(name, color, texture);
        trees.add(new Tree(x, y, type));
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public int treeCount() {
        return trees.size();
    }

    public int distinctTreeTypeCount() {
        return treeFactory.cachedTypeCount();
    }
}
