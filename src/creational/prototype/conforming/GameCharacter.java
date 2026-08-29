package creational.prototype.conforming;

// The Prototype abstraction: "a character that knows how to copy
// itself." Clients depend on this and on CharacterFactory, never on a
// concrete OrcWarrior/ElfArcher constructor (DIP) -- the same shape as
// creational.abstractfactory.conforming's Button/Checkbox abstractions.
public abstract class GameCharacter {
    protected int health = 100;

    public abstract GameCharacter copy();

    public abstract void describe();

    public void damage(int amount) {
        health -= amount;
    }
}
