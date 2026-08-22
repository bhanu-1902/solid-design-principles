package dip.buttonlamp.conforming;

// Figure 6 / Listing 6: Button depends only on the abstract
// ButtonClient, and on its OWN abstract sensing hook (getState()).
// It knows nothing about Lamps, Motors, or physical hardware. This
// is the Template Method pattern: Detect() is the fixed algorithm,
// getState() is the pluggable step subclasses provide.
public abstract class Button {
    private final ButtonClient client;

    protected Button(ButtonClient client) {
        this.client = client;
    }

    protected abstract boolean getState();

    public void detect() {
        if (getState()) {
            client.turnOn();
        } else {
            client.turnOff();
        }
    }
}
