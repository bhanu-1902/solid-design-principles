package isp.door.conforming;

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
