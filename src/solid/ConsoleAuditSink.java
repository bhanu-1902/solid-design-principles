package solid;

public class ConsoleAuditSink implements AuditSink {
    @Override
    public void record(String message) {
        System.out.println("[AUDIT] " + message);
    }
}
