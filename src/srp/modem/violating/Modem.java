package srp.modem.violating;

// Listing 9-1, translated directly. Two responsibilities bundled into
// one interface: connection management (dial/hangup) and data
// communication (send/recv). They have almost nothing in common,
// change for different reasons, and are called from completely
// different parts of a real application.
public interface Modem {
    void dial(String phoneNumber);
    void hangup();
    void send(char c);
    char recv();
}
