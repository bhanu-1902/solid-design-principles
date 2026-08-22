package isp.door.violating;

// A perfectly ordinary door that needs NO timing at all -- yet because
// Door extends TimerClient, it is still forced to provide SOME
// implementation of timeOut(). This nil/no-op implementation is
// exactly the LSP smell from two conversations ago: an override that
// does nothing is a postcondition silently dropped.
public class PlainDoor implements Door {
    private boolean open = false;

    @Override
    public void lock() {
        open = false;
        System.out.println("PlainDoor: locked");
    }

    @Override
    public void unlock() {
        open = true;
        System.out.println("PlainDoor: unlocked");
    }

    @Override
    public boolean isDoorOpen() {
        return open;
    }

    @Override
    public void timeOut(int timeOutId) {
        // Forced nil implementation. PlainDoor has no concept of a
        // timeout, but the polluted Door interface demands one anyway.
    }
}
