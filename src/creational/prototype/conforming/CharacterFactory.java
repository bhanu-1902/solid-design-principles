package creational.prototype.conforming;

import java.util.HashMap;
import java.util.Map;

// The prototype registry. Expensive setup happens exactly once per kind,
// at registration time; every spawn() call after that is a cheap copy().
// Registering a third kind is one line here -- nothing about how existing
// kinds are spawned changes (OCP).
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
        return prototype.copy();
    }
}
