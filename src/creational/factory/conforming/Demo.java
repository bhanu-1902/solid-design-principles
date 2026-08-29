package creational.factory.conforming;

public class Demo {
    static Coin mintDailyReward(CoinType type) {
        return CoinFactory.getCoin(type);
    }

    static Coin mintQuestReward(CoinType type) {
        return CoinFactory.getCoin(type);
    }

    public static void run() {
        System.out.println(mintDailyReward(CoinType.GOLD).describe());
        System.out.println(mintQuestReward(CoinType.SILVER).describe());
        System.out.println(CoinFactory.getCoin(CoinType.COPPER).describe());

        System.out.println();
        System.out.println("Every caller goes through CoinFactory.getCoin() and names only");
        System.out.println("Coin/CoinType -- never GoldCoin, SilverCoin, or CopperCoin. Adding");
        System.out.println("a PlatinumCoin is one new CoinType constant, in one file.");
    }

    public static void main(String[] args) {
        run();
    }
}
