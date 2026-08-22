package srp.modem.violating;

public class HardwareModem implements Modem {
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
