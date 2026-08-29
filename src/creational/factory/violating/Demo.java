package creational.factory.violating;

// No factory at all: two unrelated call sites each re-implement the same
// "type string -> concrete Coin" decision. There's no single place a new
// coin type gets wired in -- every method in the codebase that mints coins
// has to be found and updated by hand, and each one depends directly on
// GoldCoin/SilverCoin/CopperCoin (violates DIP, in duplicate).
public class Demo {
    static Coin mintDailyReward(String type) {
        if (type.equals("gold")) {
            return new GoldCoin();
        } else if (type.equals("silver")) {
            return new SilverCoin();
        }
        return new CopperCoin();
    }

    static Coin mintQuestReward(String type) {
        // The exact same decision, duplicated. Add "platinum" and you must
        // remember to update both methods identically -- nothing forces that.
        if (type.equals("gold")) {
            return new GoldCoin();
        } else if (type.equals("silver")) {
            return new SilverCoin();
        }
        return new CopperCoin();
    }

    public static void run() {
        System.out.println(mintDailyReward("gold").describe());
        System.out.println(mintQuestReward("gold").describe());

        System.out.println();
        System.out.println("Both methods know about GoldCoin/SilverCoin/CopperCoin directly,");
        System.out.println("and both re-implement the same type->class decision. A new coin");
        System.out.println("type means finding and editing every call site like this one.");
    }

    public static void main(String[] args) {
        run();
    }
}
