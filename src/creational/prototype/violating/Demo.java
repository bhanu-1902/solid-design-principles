package creational.prototype.violating;

public class Demo {
    public static void run() {
        System.out.println("Spawning 3 orc warriors -- each pays the setup cost again:");
        OrcWarrior orc1 = new OrcWarrior("Orc #1");
        OrcWarrior orc2 = new OrcWarrior("Orc #2");
        OrcWarrior orc3 = new OrcWarrior("Orc #3");
        orc1.describe();
        orc2.describe();
        orc3.describe();

        System.out.println();
        System.out.println("Every spawn point in the codebase that wants an orc warrior has to");
        System.out.println("know how to build one from scratch, and re-pays the setup cost");
        System.out.println("every single time.");
    }

    public static void main(String[] args) {
        run();
    }
}
