package dip.buttonlamp.conforming;

// The underlying abstraction: "something that can be turned on or
// off." Not a Lamp, not a Motor -- just the truth that survives no
// matter which device is behind it.
public interface ButtonClient {
    void turnOn();
    void turnOff();
}
