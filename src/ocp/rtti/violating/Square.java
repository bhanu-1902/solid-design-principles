package ocp.rtti.violating;

public class Square extends Shape {
    final double topLeftX, topLeftY, side;

    Square(double topLeftX, double topLeftY, double side) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.side = side;
    }
}
