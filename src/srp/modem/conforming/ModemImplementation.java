package srp.modem.conforming;

// Martin calls this class a "kludge" or a "wart" -- the hardware
// forces both responsibilities back together in ONE concrete class,
// because dialing and data transfer share the same physical device.
// That's fine, AS LONG AS all dependencies flow AWAY from it: nobody
// needs to depend on ModemImplementation itself, only on Connection
// or DataChannel individually. The ugliness stays fenced in here.
public class ModemImplementation implements Connection, DataChannel {
    private boolean connected = false;

    @Override
    public void dial(String phoneNumber) {
        connected = true;
        System.out.println("Dialing " + phoneNumber + "... connected.");
    }

    @Override
    public void hangup() {
        connected = false;
        System.out.println("Hung up.");
    }

    @Override
    public void send(char c) {
        System.out.println("Sending: " + c);
    }

    @Override
    public char recv() {
        System.out.println("Receiving...");
        return 'X';
    }
}
