package structural.bridge.conforming;

// The implementor side of the bridge: "how to name/render a color," kept
// completely separate from "what shape this is." Shape depends on this
// abstraction, never on a concrete color (DIP) -- which is exactly what
// lets shape and color vary independently instead of multiplying.
public interface Color {
    String name();
}
