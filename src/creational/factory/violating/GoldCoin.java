package creational.factory.violating;

public class GoldCoin implements Coin {
    @Override
    public String describe() {
        return "Gold coin (value 100)";
    }
}
