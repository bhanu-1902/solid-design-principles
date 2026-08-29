package creational.builder.conforming;

// Construction (the Builder's job -- SRP) is now a separate concern from
// representation (this class's only job: hold validated, immutable state).
// Every field is set through a named method, so a call site reads as
// "cpu=..., ram=..., gpu enabled" instead of a row of bare literals -- and
// adding a new optional attribute is one new field plus one new Builder
// method, which cannot break any existing caller (OCP: this class and
// every current call site are unaffected).
public final class Computer {
    private final String cpu;
    private final int ramGb;
    private final int storageGb;
    private final boolean hasGpu;
    private final boolean hasBluetooth;
    private final boolean hasWifi;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ramGb = builder.ramGb;
        this.storageGb = builder.storageGb;
        this.hasGpu = builder.hasGpu;
        this.hasBluetooth = builder.hasBluetooth;
        this.hasWifi = builder.hasWifi;
    }

    @Override
    public String toString() {
        return "Computer{cpu=%s, ramGb=%d, storageGb=%d, hasGpu=%b, hasBluetooth=%b, hasWifi=%b}"
                .formatted(cpu, ramGb, storageGb, hasGpu, hasBluetooth, hasWifi);
    }

    public static class Builder {
        private final String cpu;
        private final int ramGb;
        private int storageGb = 256;
        private boolean hasGpu = false;
        private boolean hasBluetooth = false;
        private boolean hasWifi = false;

        public Builder(String cpu, int ramGb) {
            this.cpu = cpu;
            this.ramGb = ramGb;
        }

        public Builder storageGb(int storageGb) {
            this.storageGb = storageGb;
            return this;
        }

        public Builder withGpu() {
            this.hasGpu = true;
            return this;
        }

        public Builder withBluetooth() {
            this.hasBluetooth = true;
            return this;
        }

        public Builder withWifi() {
            this.hasWifi = true;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
