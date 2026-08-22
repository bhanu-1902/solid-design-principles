package ocp.encapsulation;

public class Demo {
    public static void run() {
        Device device = new Device();
        device.status = true; // a well-behaved client, after a real operation
        System.out.println("Device.status after a real operation: " + device.status);

        // A misbehaving client can do this too -- nothing stops it,
        // and every OTHER client reading device.status is now misled.
        device.status = true; // no operation actually happened
        System.out.println("Device.status after a MISBEHAVING client wrote it directly: " + device.status);
        System.out.println("-> This is Martin's argument for making Device.status private.");

        System.out.println();
        Time t = new Time(23, 59, 0);
        System.out.println("Time starts at " + t);
        t.plusSeconds(90);
        System.out.println("After +90s: " + t + " (public fields are fine here -- clients are meant to mutate them)");
    }

    public static void main(String[] args) {
        run();
    }
}
