package dip.buttonlamp.conforming;

// A NEW target, added after Button already shipped. Zero changes to
// Button or ButtonImplementation -- exactly Martin's point about
// reusing the high-level policy "in many different detailed contexts."
public class Motor implements ButtonClient {
    @Override
    public void turnOn() {
        System.out.println("Motor: running");
    }

    @Override
    public void turnOff() {
        System.out.println("Motor: stopped");
    }
}
