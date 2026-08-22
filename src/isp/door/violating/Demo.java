package isp.door.violating;

public class Demo {
    public static void run() {
        Timer timer = new Timer();

        TimedDoor timedDoor = new TimedDoor();
        timedDoor.unlock();
        timer.register(30000, 1, timedDoor);
        timer.simulateExpiry();

        System.out.println();
        System.out.println("PlainDoor never needs timing, yet still had to implement timeOut():");
        PlainDoor plainDoor = new PlainDoor();
        plainDoor.unlock();
        plainDoor.timeOut(999); // does nothing -- forced no-op

        System.out.println();
        System.out.println("Every class that depends on Door (locking UIs, access logs, etc.)");
        System.out.println("transitively depends on TimerClient too -- and would need to");
        System.out.println("recompile if Timer's registration signature ever changes, even");
        System.out.println("though most Door clients never touch timing at all.");
    }

    public static void main(String[] args) {
        run();
    }
}
