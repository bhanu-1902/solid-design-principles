package dip.copy.conforming;

public class Demo {
    public static void run() {
        System.out.println("copy(keyboard, printer):");
        Copy.copy(new KeyboardReader(), new PrinterWriter());

        System.out.println();
        System.out.println("copy(keyboard, disk) -- SAME Copy.copy(), zero changes:");
        Copy.copy(new KeyboardReader(), new DiskWriter());

        System.out.println();
        System.out.println("Copy.java was written once and never touched again. A brand new");
        System.out.println("Writer (network socket, cloud bucket, anything) plugs in the same");
        System.out.println("way DiskWriter just did.");
    }

    public static void main(String[] args) {
        run();
    }
}
