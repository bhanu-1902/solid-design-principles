package dip.buttonlamp.conforming;

// The concrete sensing detail -- simulated here rather than reading
// real hardware, but the point is the same: THIS class depends on
// Button's abstraction, not the other way around.
public class ButtonImplementation extends Button {
    private boolean physicalState = false;

    public ButtonImplementation(ButtonClient client) {
        super(client);
    }

    public void press(boolean on) {
        physicalState = on;
        detect();
    }

    @Override
    protected boolean getState() {
        return physicalState;
    }
}
