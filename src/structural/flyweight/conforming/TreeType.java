package structural.flyweight.conforming;

// The flyweight: intrinsic state (name/color/texture) that's identical
// across every tree of this species, stored exactly once and shared by
// reference. Extrinsic state (where a specific tree stands) is passed in
// per call instead of stored here -- that's what keeps this object
// safely shareable across thousands of Tree instances.
public class TreeType {
    private final String name;
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + color + " " + name + " (texture=" + texture + ") at (" + x + "," + y + ")");
    }
}
