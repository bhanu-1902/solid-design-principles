package isp.door.conforming;

public class Demo {
    public static void run() {
        Timer timer = new Timer();

        System.out.println("Multiple-interface form (Martin's preference; free in Java):");
        TimedDoor timedDoor = new TimedDoor();
        timedDoor.unlock();
        timer.register(30000, 1, timedDoor); // TimedDoor passed directly as TimerClient
        timer.simulateExpiry();

        System.out.println();
        System.out.println("Delegation form, for comparison (object Adapter):");
        TimedDoor anotherTimedDoor = new TimedDoor();
        anotherTimedDoor.unlock();
        timer.register(30000, 2, new DoorTimerAdapter(anotherTimedDoor));
        timer.simulateExpiry();

        System.out.println();
        System.out.println("PlainDoor implements ONLY Door -- no forced timeOut() at all:");
        PlainDoor plainDoor = new PlainDoor();
        plainDoor.unlock();
        System.out.println("isDoorOpen() = " + plainDoor.isDoorOpen());

        System.out.println();
        System.out.println("Clients that only use Door never depend on TimerClient. A change");
        System.out.println("to Timer's registration signature recompiles TimedDoor and its");
        System.out.println("adapter -- never PlainDoor, never generic Door clients.");
    }

    public static void main(String[] args) {
        run();
    }
}
