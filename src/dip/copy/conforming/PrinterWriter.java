package dip.copy.conforming;

public class PrinterWriter implements Writer {
    @Override
    public void write(char c) {
        System.out.println("PRINTER: " + c);
    }
}
