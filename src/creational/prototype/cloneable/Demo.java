package creational.prototype.cloneable;

public class Demo {
    public static void run() {
        CharacterFactory factory = new CharacterFactory();
        factory.registerPrototype("orc-warrior", new OrcWarrior("Orc Prototype"));
        factory.registerPrototype("elf-archer", new ElfArcher("Elf Prototype"));

        System.out.println();
        System.out.println("Spawning 2 orc warriors via clone() instead of copy():");
        GameCharacter orc1 = factory.spawn("orc-warrior");
        GameCharacter orc2 = factory.spawn("orc-warrior");
        orc1.describe();
        orc2.describe();

        System.out.println();
        System.out.println("Clones are still independent -- OrcWarrior.clone() manually");
        System.out.println("deep-copies equipment after super.clone(). Skip that one line");
        System.out.println("and this next call would silently corrupt orc2's list too:");
        orc1.addLoot("Enchanted Axe");
        orc1.describe();
        orc2.describe();

        System.out.println();
        System.out.println("orc1 == orc2 -> " + (orc1 == orc2));

        System.out.println();
        System.out.println("What this cost, compared to .conforming's copy constructor:");
        System.out.println("  - name/equipment can no longer be final (clone()'s fixup reassigns them)");
        System.out.println("  - every clone() override repeats the same try/catch boilerplate");
        System.out.println("  - forgetting the fixup line fails silently, not at compile time --");
        System.out.println("    a copy constructor can't compile without touching every field");
    }

    public static void main(String[] args) {
        run();
    }
}
