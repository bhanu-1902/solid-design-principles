package dip.copy.conforming;

// Listing 3: the high-level policy depends ONLY on the Reader/Writer
// abstractions. It has never heard of a keyboard, a printer, or a
// disk. This is dependency INVERSION -- Copy used to depend on the
// details; now the details (KeyboardReader, PrinterWriter, DiskWriter)
// depend on the same abstractions Copy depends on.
public class Copy {
    public static void copy(Reader r, Writer w) {
        int c;
        while ((c = r.read()) != -1) {
            w.write((char) c);
        }
    }
}
