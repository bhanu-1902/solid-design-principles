package ocp.encapsulation;

// Listing 8. Martin's point: public fields here are mostly harmless
// -- clients are SUPPOSED to read and write hours/minutes/seconds
// directly, and no subclass is likely to want to intercept a single
// field write. His only real complaint: mutation isn't atomic (you
// can change minutes without hours) -- a weak argument, in his view,
// against keeping the fields public.
public class Time implements Comparable<Time> {
    public int hours, minutes, seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time plusSeconds(int delta) {
        int total = toTotalSeconds() + delta;
        hours = Math.floorMod(Math.floorDiv(total, 3600), 24);
        minutes = Math.floorDiv(total, 60) % 60;
        seconds = Math.floorMod(total, 60);
        return this;
    }

    public Time minusSeconds(int delta) {
        return plusSeconds(-delta);
    }

    @Override
    public int compareTo(Time other) {
        return Integer.compare(this.toTotalSeconds(), other.toTotalSeconds());
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private int toTotalSeconds() {
        return hours * 3600 + minutes * 60 + seconds;
    }
}
