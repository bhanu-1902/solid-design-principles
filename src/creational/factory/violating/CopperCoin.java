package creational.factory.violating;

public class CopperCoin implements Coin {
    @Override
    public String describe() {
        return "Copper coin (value 1)";
    }
}
