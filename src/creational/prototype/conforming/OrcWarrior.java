package creational.prototype.conforming;

import java.util.ArrayList;
import java.util.List;

public class OrcWarrior extends GameCharacter {
    private final String name;
    private final List<String> equipment;

    public OrcWarrior(String name) {
        this.name = name;
        System.out.println("  (expensive setup, runs once) forging equipment for the " + name + " prototype...");
        this.equipment = new ArrayList<>(List.of("Axe", "Shield"));
    }

    private OrcWarrior(OrcWarrior source) {
        this.name = source.name;
        this.health = source.health;
        this.equipment = new ArrayList<>(source.equipment); // deep copy: clones don't share mutable state
    }

    @Override
    public GameCharacter copy() {
        return new OrcWarrior(this);
    }

    @Override
    public void describe() {
        System.out.println(name + " [" + health + "hp] equipment=" + equipment);
    }
}
