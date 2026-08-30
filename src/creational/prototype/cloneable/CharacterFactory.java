package creational.prototype.cloneable;

import java.util.HashMap;
import java.util.Map;

// Identical shape to creational.prototype.conforming.CharacterFactory --
// spawn() still just calls one method to get a copy. Only the method
// name changed (clone() instead of copy()); every cost of the Cloneable
// approach is paid inside GameCharacter/OrcWarrior/ElfArcher, not here.
public class CharacterFactory {
    private final Map<String, GameCharacter> prototypes = new HashMap<>();

    public void registerPrototype(String key, GameCharacter prototype) {
        prototypes.put(key, prototype);
    }

    public GameCharacter spawn(String key) {
        GameCharacter prototype = prototypes.get(key);
        if (prototype == null) {
            throw new IllegalArgumentException("No prototype registered for: " + key);
        }
        return prototype.clone();
    }
}
