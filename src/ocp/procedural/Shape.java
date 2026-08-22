package ocp.procedural;

// The Java analogue of Martin's "common first member" trick: this
// interface exists purely so a switch statement can find out what
// concrete type it's holding.
public interface Shape {
    ShapeType getType();
}
