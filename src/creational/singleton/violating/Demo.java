package creational.singleton.violating;

public class Demo {
    public static void run() {
        ConfigurationManager a = ConfigurationManager.getInstance();
        ConfigurationManager b = ConfigurationManager.getInstance();
        System.out.println("a == b -> " + (a == b));

        a.set("retries", "5");
        System.out.println("b sees a's change (shared global state): retries=" + b.get("retries"));

        System.out.println("Every caller names ConfigurationManager directly -- there is no");
        System.out.println("abstraction to substitute a fake for in a test (violates DIP), and");
        System.out.println("getInstance() itself is not safe under concurrent first use.");
    }

    public static void main(String[] args) {
        run();
    }
}
