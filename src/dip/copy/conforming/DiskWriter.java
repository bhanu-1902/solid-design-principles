package dip.copy.conforming;

// Added AFTER Copy already shipped -- zero changes to Copy, Reader,
// or any existing Writer. That's the payoff of dependency inversion:
// Copy depends on the Writer abstraction, never on this class.
public class DiskWriter implements Writer {
    @Override
    public void write(char c) {
        System.out.println("DISK: " + c);
    }
}
