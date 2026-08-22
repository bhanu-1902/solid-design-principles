package srp.modem.conforming;

// One responsibility: managing the connection.
public interface Connection {
    void dial(String phoneNumber);
    void hangup();
}
