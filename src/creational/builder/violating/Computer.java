package creational.builder.violating;

// A "telescoping constructor": every combination of optional parameters
// gets its own overload, and callers who want, say, GPU + WiFi but not
// Bluetooth are forced through the widest overload anyway. Two problems
// compound here. First, positional booleans/ints are easy to transpose by
// accident -- the compiler cannot catch a caller who swaps hasBluetooth
// and hasWifi. Second, this class bundles "what a computer's fields are"
// with "every legal way to assemble one," so a new optional feature means
// a new overload, which is an OCP problem hiding inside what looks like a
// plain data class.
public class Computer {
    private final String cpu;
    private final int ramGb;
    private final int storageGb;
    private final boolean hasGpu;
    private final boolean hasBluetooth;
    private final boolean hasWifi;

    public Computer(String cpu, int ramGb) {
        this(cpu, ramGb, 256, false, false, false);
    }

    public Computer(String cpu, int ramGb, int storageGb) {
        this(cpu, ramGb, storageGb, false, false, false);
    }

    public Computer(String cpu, int ramGb, int storageGb, boolean hasGpu,
                     boolean hasBluetooth, boolean hasWifi) {
        this.cpu = cpu;
        this.ramGb = ramGb;
        this.storageGb = storageGb;
        this.hasGpu = hasGpu;
        this.hasBluetooth = hasBluetooth;
        this.hasWifi = hasWifi;
    }

    @Override
    public String toString() {
        return "Computer{cpu=%s, ramGb=%d, storageGb=%d, hasGpu=%b, hasBluetooth=%b, hasWifi=%b}"
                .formatted(cpu, ramGb, storageGb, hasGpu, hasBluetooth, hasWifi);
    }
}
