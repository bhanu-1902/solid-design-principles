package srp.modem.conforming;

public class Demo {
    // A client typed to depend on ONLY DataChannel never has to know
    // Connection (or dialing) exists at all.
    static void transferSomeData(DataChannel channel) {
        channel.send('A');
        channel.recv();
    }

    public static void run() {
        ModemImplementation modem = new ModemImplementation();
        modem.dial("555-0100");

        System.out.println("A data-only client, typed as DataChannel, not Modem:");
        transferSomeData(modem);

        modem.hangup();
        System.out.println("transferSomeData() depends on DataChannel alone. A change to");
        System.out.println("how dial() works never touches it, never forces it to recompile.");
    }

    public static void main(String[] args) {
        run();
    }
}
