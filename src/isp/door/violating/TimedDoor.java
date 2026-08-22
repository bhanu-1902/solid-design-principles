package isp.door.violating;

public class TimedDoor implements Door {
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
