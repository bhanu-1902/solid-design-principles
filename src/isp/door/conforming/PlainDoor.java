package isp.door.conforming;

// No pollution: PlainDoor implements ONLY Door. There is no timeOut()
// to fake, no nil method, no accidental dependency on TimerClient.
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
}
