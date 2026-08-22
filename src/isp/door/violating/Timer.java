package isp.door.violating;

// Simplified stand-in for a real timer service. register() would
// normally schedule an async callback; here we just keep the
// registration so Demo can trigger it manually and keep the example
// deterministic.
public class Timer {
    private TimerClient lastClient;
    private int lastTimeoutId;

    public void register(int timeoutMillis, int timeOutId, TimerClient client) {
        System.out.println("Timer: registered id=" + timeOutId + " for " + timeoutMillis + "ms");
        this.lastClient = client;
        this.lastTimeoutId = timeOutId;
    }

    public void simulateExpiry() {
        if (lastClient != null) {
            lastClient.timeOut(lastTimeoutId);
        }
    }
}
