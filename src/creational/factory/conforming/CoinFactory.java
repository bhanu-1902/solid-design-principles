package creational.factory.conforming;

// The Factory itself: one static method every caller goes through. Callers
// depend on Coin and CoinFactory/CoinType -- never on GoldCoin, SilverCoin,
// or CopperCoin by name (DIP, the same relationship
// creational.abstractfactory.conforming's Application has to GUIFactory).
//
// Worth being precise about what this does and doesn't buy you: a new
// PlatinumCoin still means adding one CoinType constant here -- one edit,
// not the two-plus duplicated edits in .violating, but not the zero-edit
// guarantee creational.factorymethod.conforming gets from letting
// subclasses decide. Factory centralizes the decision; Factory Method
// eliminates it.
public class CoinFactory {
    public static Coin getCoin(CoinType type) {
        return type.getConstructor().get();
    }
}
