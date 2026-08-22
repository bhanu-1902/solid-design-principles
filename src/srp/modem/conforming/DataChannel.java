package srp.modem.conforming;

// The other responsibility: communicating data.
public interface DataChannel {
    void send(char c);
    char recv();
}
