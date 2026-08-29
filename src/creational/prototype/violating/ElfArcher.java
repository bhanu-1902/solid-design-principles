package creational.prototype.violating;

import java.util.ArrayList;
import java.util.List;

public class ElfArcher {
    private final String name;
    private final List<String> equipment = new ArrayList<>();
    private int health = 100;

    public ElfArcher(String name) {
        this.name = name;
        System.out.println("  (expensive setup) fletching arrows for " + name + "...");
        equipment.add("Bow");
        equipment.add("Quiver");
    }

    public void describe() {
        System.out.println(name + " [" + health + "hp] equipment=" + equipment);
    }
}
