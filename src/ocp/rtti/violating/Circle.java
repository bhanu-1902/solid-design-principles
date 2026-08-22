package ocp.rtti.violating;

// Package-private fields/constructor: the nearest Java equivalent of
// C++ `friend` -- visible to ShapeDrawer because it's in the same
// package, invisible to everything outside it.
public class Circle extends Shape {
    final double centerX, centerY, radius;

    Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
}
