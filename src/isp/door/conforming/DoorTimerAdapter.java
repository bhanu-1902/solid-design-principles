package isp.door.conforming;

// The OTHER solution Martin discusses: the object form of Adapter,
// via delegation instead of multiple-interface-implementation. Useful
// when the TimedDoor-like class can't or shouldn't implement
// TimerClient directly -- e.g. it needs a DIFFERENT translation, or
// the two interfaces need to vary independently at different times.
// Costs one extra object and one extra indirection per registration.
public class DoorTimerAdapter implements TimerClient {
    private final TimedDoor door;

    public DoorTimerAdapter(TimedDoor door) {
        this.door = door;
    }

    @Override
    public void timeOut(int timeOutId) {
        door.timeOut(timeOutId);
    }
}
