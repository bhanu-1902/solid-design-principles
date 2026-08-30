package structural.facade.violating;

// Two different callers need "start the computer," and both have to know
// the exact subsystem ordering: freeze the CPU, read the boot sector,
// load it, jump to it, execute. That knowledge is duplicated instead of
// owned in one place, and both methods depend directly on three concrete
// subsystem classes (violates DIP; the duplication is an OCP/DRY problem --
// changing the boot sequence means finding and fixing it twice).
public class Demo {
    static void startNormally() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
    }

    static void startInSafeMode() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        System.out.println("(safe mode) skipping non-essential drivers");
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
    }

    public static void run() {
        System.out.println("-- normal boot --");
        startNormally();
        System.out.println("-- safe-mode boot --");
        startInSafeMode();

        System.out.println();
        System.out.println("The freeze->load->jump->execute sequence is duplicated in both");
        System.out.println("methods, and both know all three subsystem classes directly.");
    }

    public static void main(String[] args) {
        run();
    }
}
