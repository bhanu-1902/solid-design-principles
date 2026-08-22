package srp.modem.violating;

public class Demo {
    public static void run() {
        Modem modem = new HardwareModem();
        modem.dial("555-0100");
        modem.send('A');
        modem.recv();
        modem.hangup();

        System.out.println("Any code that only ever needs to send/recv data still has to");
        System.out.println("depend on the WHOLE Modem interface, including dial()/hangup().");
        System.out.println("A change to how dialing works can force that code to recompile,");
        System.out.println("even though it never dials anything.");
    }

    public static void main(String[] args) {
        run();
    }
}
