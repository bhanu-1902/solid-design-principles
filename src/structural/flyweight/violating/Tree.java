package structural.flyweight.violating;

// Every tree carries its own full copy of "intrinsic" data (name, color,
// texture) even though many trees of the same species share an identical
// copy. In a real renderer, texture might be megabytes; here it's a
// stand-in string, but the duplication problem is the same: memory grows
// with the number of trees, not the number of distinct species.
public class Tree {
    private final String name;
    private final String color;
    private final String texture;
    private final int x;
    private final int y;

    public Tree(String name, String color, String texture, int x, int y) {
        this.name = name;
        this.color = color;
        this.texture = texture;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("Drawing " + color + " " + name + " (texture=" + texture + ") at (" + x + "," + y + ")");
    }
}
