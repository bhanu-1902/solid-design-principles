package creational.prototype.cloneable;

// The textbook Java mechanism for Prototype: implement Cloneable and
// override clone(). Compare this package to
// creational.prototype.conforming's copy-constructor approach -- same
// pattern, same intent (CharacterFactory still just calls one method to
// get a copy), considerably more ceremony to get there.
public abstract class GameCharacter implements Cloneable {
    protected int health = 100;

    public abstract void describe();
    public abstract void addLoot(String item);

    public void damage(int amount) {
        health -= amount;
    }

    @Override
    public GameCharacter clone() {
        try {
            // Object.clone() does a shallow, field-by-field bit-copy and
            // never runs a constructor. For a primitive field like health
            // that's already correct; for any reference field (a List, an
            // array, another object) it copies the REFERENCE, not the
            // contents -- the clone and the original would point at the
            // exact same object until a subclass fixes that up (see
            // OrcWarrior.clone()).
            return (GameCharacter) super.clone();
        } catch (CloneNotSupportedException e) {
            // Can't actually happen: this class implements Cloneable.
            // Object.clone() only throws this for classes that DON'T --
            // it's a checked exception kept for historical reasons, and
            // every clone() override ends up with this exact boilerplate.
            throw new AssertionError("Cloneable but clone() failed", e);
        }
    }
}
