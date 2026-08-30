package structural.bridge.conforming;

// The abstraction side of the bridge. Shape holds a Color rather than
// extending one, so a new Color works with every existing Shape
// automatically, and a new Shape works with every existing Color
// automatically -- N shapes + M colors, not N*M classes. This "color"
// field is also a clean example of plain Aggregation: Shape doesn't
// create or own the Color's lifecycle, it's just handed a reference that
// exists independently and could be shared across many shapes.
public abstract class Shape {
    protected final Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
