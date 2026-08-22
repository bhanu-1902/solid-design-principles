package dip.copy.violating;

public class Copy {
    // Listing 1: the high-level policy (copy loop) directly depends
    // on TWO concrete low-level details. Reusing this loop to copy
    // somewhere else means editing this class.
    public static void copyToPrinter() {
        KeyboardReader reader = new KeyboardReader();
        PrinterWriter writer = new PrinterWriter();
        int c;
        while ((c = reader.read()) != -1) {
            writer.write((char) c);
        }
    }

    // Listing 2, the "enhanced" version: adding disk support via an
    // if/else on a flag. This is STILL a violation -- it just hides
    // it one level down. Every new device means another branch here,
    // and Copy now depends on every device it can possibly target.
    public static void copyEnhanced(OutputDevice device) {
        KeyboardReader reader = new KeyboardReader();
        PrinterWriter printer = new PrinterWriter();
        DiskWriter disk = new DiskWriter();
        int c;
        while ((c = reader.read()) != -1) {
            if (device == OutputDevice.PRINTER) {
                printer.write((char) c);
            } else {
                disk.write((char) c);
            }
        }
    }
}
