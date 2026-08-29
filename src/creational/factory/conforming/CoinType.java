package creational.factory.conforming;

import java.util.function.Supplier;

// One centralized mapping from "kind of coin" to "how to build one." This
// is the Factory pattern's core idea: a single place owns the type-to-class
// decision, instead of it being duplicated at every call site the way
// .violating's Demo does it.
public enum CoinType {
    GOLD(GoldCoin::new),
    SILVER(SilverCoin::new),
    COPPER(CopperCoin::new);

    private final Supplier<Coin> constructor;

    CoinType(Supplier<Coin> constructor) {
        this.constructor = constructor;
    }

    Supplier<Coin> getConstructor() {
        return constructor;
    }
}
