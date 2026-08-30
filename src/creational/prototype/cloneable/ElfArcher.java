package creational.prototype.cloneable;

import java.util.ArrayList;
import java.util.List;

public class ElfArcher extends GameCharacter {
    private String name;
    private List<String> equipment;

    public ElfArcher(String name) {
        this.name = name;
        System.out.println("  (expensive setup, runs once) fletching arrows for the " + name + " prototype...");
        this.equipment = new ArrayList<>(List.of("Bow", "Quiver"));
    }

    @Override
    public ElfArcher clone() {
        ElfArcher clone = (ElfArcher) super.clone();
        clone.equipment = new ArrayList<>(this.equipment);
        return clone;
    }

    @Override
    public void addLoot(String item) {
        equipment.add(item);
    }

    @Override
    public void describe() {
        System.out.println(name + " [" + health + "hp] equipment=" + equipment);
    }
}
