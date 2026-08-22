package dip.copy.violating;

public class Demo {
    public static void run() {
        System.out.println("copyToPrinter() -- hard-wired to KeyboardReader + PrinterWriter:");
        Copy.copyToPrinter();

        System.out.println();
        System.out.println("copyEnhanced(DISK) -- 'fixed' with an if/else, still a violation:");
        Copy.copyEnhanced(OutputDevice.DISK);

        System.out.println();
        System.out.println("Adding a THIRD device (network, cloud storage, ...) means editing");
        System.out.println("Copy again -- the high-level policy is not closed against new");
        System.out.println("low-level details, because it depends on them directly.");
    }

    public static void main(String[] args) {
        run();
    }
}
