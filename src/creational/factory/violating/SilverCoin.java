package creational.factory.violating;

public class SilverCoin implements Coin {
    @Override
    public String describe() {
        return "Silver coin (value 50)";
    }
}
