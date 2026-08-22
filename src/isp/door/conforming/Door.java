package isp.door.conforming;

// Clean again: Door knows nothing about timing.
public interface Door {
    void lock();
    void unlock();
    boolean isDoorOpen();
}
