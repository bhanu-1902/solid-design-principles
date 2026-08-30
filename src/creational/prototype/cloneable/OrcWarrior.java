package creational.prototype.cloneable;

import java.util.ArrayList;
import java.util.List;

public class OrcWarrior extends GameCharacter {
    // Neither field can be final here. super.clone()'s shallow copy sets
    // them once already (bypassing the constructor entirely), and the
    // manual deep-copy fixup below has to reassign equipment afterward --
    // a reassignment "final" would forbid. creational.prototype.conforming's
    // OrcWarrior has no such restriction, because a copy constructor sets
    // final fields exactly once, in the constructor, the normal way.
    private String name;
    private List<String> equipment;

    public OrcWarrior(String name) {
        this.name = name;
        System.out.println("  (expensive setup, runs once) forging equipment for the " + name + " prototype...");
        this.equipment = new ArrayList<>(List.of("Axe", "Shield"));
    }

    @Override
    public OrcWarrior clone() {
        OrcWarrior clone = (OrcWarrior) super.clone(); // shallow: clone.equipment == this.equipment right now
        clone.equipment = new ArrayList<>(this.equipment); // the manual fixup -- forget this line and both
                                                            // "copies" would silently share one equipment list
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
