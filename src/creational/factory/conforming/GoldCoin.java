package creational.factory.conforming;

public class GoldCoin implements Coin {
    @Override
    public String describe() {
        return "Gold coin (value 100)";
    }
}
