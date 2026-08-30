package structural.facade.conforming;

public class Demo {
    public static void run() {
        ComputerFacade computer = new ComputerFacade();

        System.out.println("-- normal boot --");
        computer.start();
        System.out.println("-- safe-mode boot --");
        computer.startInSafeMode();

        System.out.println();
        System.out.println("Demo never mentioned CPU, Memory, or HardDrive -- only");
        System.out.println("ComputerFacade. The boot sequence exists in one place, inside it.");
    }

    public static void main(String[] args) {
        run();
    }
}
