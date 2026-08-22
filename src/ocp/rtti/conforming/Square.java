package ocp.rtti.conforming;

public class Square extends Shape {
    private final double topLeftX, topLeftY, side;

    public Square(double topLeftX, double topLeftY, double side) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.printf("Square   side=%.1f at (%.1f, %.1f)%n", side, topLeftX, topLeftY);
    }
}
