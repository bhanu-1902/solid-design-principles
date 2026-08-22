package isp.door.conforming;

// Martin's preferred fix, "the class form of Adapter": TimedDoor
// simply implements BOTH interfaces directly. In C++ this needs
// multiple inheritance; in Java, implementing two interfaces is the
// normal, idiomatic thing to do -- no adapter machinery required.
// Clients of Door don't know or care that TimedDoor also implements
// TimerClient, and vice versa.
public class TimedDoor implements Door, TimerClient {
    private boolean open = false;

    @Override
    public void lock() {
        open = false;
        System.out.println("TimedDoor: locked");
    }

    @Override
    public void unlock() {
        open = true;
        System.out.println("TimedDoor: unlocked");
    }

    @Override
    public boolean isDoorOpen() {
        return open;
    }

    @Override
    public void timeOut(int timeOutId) {
        if (open) {
            System.out.println("TimedDoor: ALARM! Door left open too long (id=" + timeOutId + ")");
        }
    }
}
