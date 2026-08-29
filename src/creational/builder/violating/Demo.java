package creational.builder.violating;

public class Demo {
    public static void run() {
        Computer office = new Computer("Intel i5", 16, 512);
        // true, false, true -- which one is GPU? Bluetooth? WiFi? The call
        // site alone can't tell you; you have to go read the overload.
        Computer gaming = new Computer("Intel i9", 32, 1024, true, false, true);
        System.out.println(office);
        System.out.println(gaming);

        System.out.println("A new optional feature (e.g. a fingerprint reader) means a new");
        System.out.println("overload -- every existing overload's meaning still has to be");
        System.out.println("reasoned about by hand.");
    }

    public static void main(String[] args) {
        run();
    }
}
