package creational.prototype.conforming;

public class Demo {
    public static void run() {
        CharacterFactory factory = new CharacterFactory();
        factory.registerPrototype("orc-warrior", new OrcWarrior("Orc Prototype"));
        factory.registerPrototype("elf-archer", new ElfArcher("Elf Prototype"));

        System.out.println();
        System.out.println("Spawning 2 orc warriors from the registered prototype --");
        System.out.println("the expensive setup already ran once, above:");
        GameCharacter orc1 = factory.spawn("orc-warrior");
        GameCharacter orc2 = factory.spawn("orc-warrior");
        orc1.describe();
        orc2.describe();

        System.out.println();
        System.out.println("Clones are independent -- damaging one doesn't touch the other,");
        System.out.println("because copy() deep-copies mutable state instead of sharing it:");
        orc1.damage(30);
        orc1.describe();
        orc2.describe();

        System.out.println();
        System.out.println("orc1 == orc2 -> " + (orc1 == orc2));

        System.out.println();
        GameCharacter elf = factory.spawn("elf-archer");
        elf.describe();
    }

    public static void main(String[] args) {
        run();
    }
}
