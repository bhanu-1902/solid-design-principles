package creational.prototype.violating;

import java.util.ArrayList;
import java.util.List;

// Every OrcWarrior re-runs the same "expensive" setup from scratch. In a
// real game this might be loading a mesh/texture or rolling procedural
// stats; here it's simulated by building up an equipment list from
// nothing. If that setup logic ever changes, every call site that does
// `new OrcWarrior(...)` needs to be revisited, because the logic isn't
// captured in one reusable place -- an OCP/DRY problem, and a DIP one too,
// since callers are wired to this concrete constructor directly.
public class OrcWarrior {
    private final String name;
    private final List<String> equipment = new ArrayList<>();
    private int health = 100;

    public OrcWarrior(String name) {
        this.name = name;
        System.out.println("  (expensive setup) forging equipment for " + name + "...");
        equipment.add("Axe");
        equipment.add("Shield");
    }

    public void describe() {
        System.out.println(name + " [" + health + "hp] equipment=" + equipment);
    }
}
