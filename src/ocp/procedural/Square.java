package ocp.procedural;

public class Square implements Shape {
    public final double side;
    public final double topLeftX, topLeftY;

    public Square(double side, double topLeftX, double topLeftY) {
        this.side = side;
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUARE;
    }
}
