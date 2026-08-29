package creational.factory.conforming;

public class SilverCoin implements Coin {
    @Override
    public String describe() {
        return "Silver coin (value 50)";
    }
}
