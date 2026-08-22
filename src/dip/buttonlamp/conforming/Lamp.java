package dip.buttonlamp.conforming;

public class Lamp implements ButtonClient {
    @Override
    public void turnOn() {
        System.out.println("Lamp: ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Lamp: OFF");
    }
}
