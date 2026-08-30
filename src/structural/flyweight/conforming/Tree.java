package structural.flyweight.conforming;

// Only the extrinsic state -- where this particular tree stands -- lives
// here. The (potentially large) intrinsic state lives once in a shared
// TreeType, referenced by every Tree of that species instead of copied
// into each one.
public class Tree {
    private final int x;
    private final int y;
    private final TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
