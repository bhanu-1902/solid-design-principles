package solid;

public interface AuditSink {
    void record(String message);
}
