package ocp.ordering.conforming;

public abstract class Shape implements Comparable<Shape> {
    public abstract void draw();

    @Override
    public int compareTo(Shape other) {
        return Integer.compare(
                ShapeOrderTable.orderOf(this.getClass()),
                ShapeOrderTable.orderOf(other.getClass())
        );
    }
}
