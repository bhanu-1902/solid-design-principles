package isp.door.violating;

// INTERFACE POLLUTION: Door has nothing to do with timing, yet it's
// forced to extend TimerClient solely so that ONE of its derivatives
// (TimedDoor) can register with a Timer. Every Door, timed or not,
// now depends on TimerClient.
public interface Door extends TimerClient {
    void lock();
    void unlock();
    boolean isDoorOpen();
}
