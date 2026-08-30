package structural.flyweight.violating;

import java.util.ArrayList;
import java.util.List;

public class Forest {
    private final List<Tree> trees = new ArrayList<>();

    public void plantTree(String name, String color, String texture, int x, int y) {
        trees.add(new Tree(name, color, texture, x, y));
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }

    public int treeCount() {
        return trees.size();
    }
}
