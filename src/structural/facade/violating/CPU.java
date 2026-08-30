package structural.facade.violating;

public class CPU {
    public void freeze() {
        System.out.println("CPU: freezing");
    }

    public void jump(long position) {
        System.out.println("CPU: jumping to " + position);
    }

    public void execute() {
        System.out.println("CPU: executing");
    }
}
