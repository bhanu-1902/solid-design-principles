package dip.buttonlamp.violating;

// Listing 5: Button (a high-level policy -- "detect a gesture, relay
// it") depends directly on the concrete Lamp class. button.cc would
// have to #include lamp.h in C++; here Button simply cannot compile
// without Lamp on the classpath. Button can NEVER be reused to
// control anything but a Lamp.
public class Button {
    private final Lamp lamp;
    private boolean physicalState = false; // simulated sensor state

    public Button(Lamp lamp) {
        this.lamp = lamp;
    }

    public void press(boolean on) {
        physicalState = on;
        detect();
    }

    private void detect() {
        if (physicalState) {
            lamp.turnOn();
        } else {
            lamp.turnOff();
        }
    }
}
