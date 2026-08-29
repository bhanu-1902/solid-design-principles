package creational.prototype.conforming;

import java.util.ArrayList;
import java.util.List;

public class ElfArcher extends GameCharacter {
    private final String name;
    private final List<String> equipment;

    public ElfArcher(String name) {
        this.name = name;
        System.out.println("  (expensive setup, runs once) fletching arrows for the " + name + " prototype...");
        this.equipment = new ArrayList<>(List.of("Bow", "Quiver"));
    }

    private ElfArcher(ElfArcher source) {
        this.name = source.name;
        this.health = source.health;
        this.equipment = new ArrayList<>(source.equipment);
    }

    @Override
    public GameCharacter copy() {
        return new ElfArcher(this);
    }

    @Override
    public void describe() {
        System.out.println(name + " [" + health + "hp] equipment=" + equipment);
    }
}
