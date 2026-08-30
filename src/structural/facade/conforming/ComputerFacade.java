package structural.facade.conforming;

// The orchestration knowledge from .violating's Demo now lives in exactly
// one place. Client code depends on ComputerFacade only -- never on CPU,
// Memory, or HardDrive directly (DIP) -- and the boot sequence has
// exactly one place to change if it ever needs to (OCP/DRY, restored).
// Note also that this class genuinely OWNS its three subsystem objects --
// they're created here and have no life outside a ComputerFacade -- which
// is a real Composition relationship, the kind dip's own abstractions
// never show because every field there is deliberately kept abstract.
public class ComputerFacade {
    private final CPU cpu = new CPU();
    private final Memory memory = new Memory();
    private final HardDrive hardDrive = new HardDrive();

    public void start() {
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
    }

    public void startInSafeMode() {
        System.out.println("(safe mode) skipping non-essential drivers");
        start();
    }
}
