package dip.buttonlamp.conforming;

// "Extending the Abstraction Further": when the target class can't be
// modified to implement ButtonClient directly, wrap it in an Adapter
// that translates turnOn/turnOff into whatever the third-party class
// actually calls its methods.
public class LampAdapter implements ButtonClient {
    private final ThirdPartyLamp lamp;

    public LampAdapter(ThirdPartyLamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void turnOn() {
        lamp.illuminate();
    }

    @Override
    public void turnOff() {
        lamp.darken();
    }
}
