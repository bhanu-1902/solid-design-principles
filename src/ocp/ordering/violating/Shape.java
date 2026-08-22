package ocp.ordering.violating;

public abstract class Shape implements Comparable<Shape> {
    public abstract void draw();

    // Listing 3's "Precedes" -- asks "should THIS be drawn before OTHER?"
    public abstract boolean precedes(Shape other);

    @Override
    public int compareTo(Shape other) {
        if (this == other) return 0;
        if (this.precedes(other)) return -1;
        if (other.precedes(this)) return 1;
        return 0;
    }
}
