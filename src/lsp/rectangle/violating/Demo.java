package lsp.rectangle.violating;

public class Demo {
    public static void run() {
        System.out.println("g(new Rectangle()):");
        ClientFunctions.g(new Rectangle());
        System.out.println("  OK -- area came out to 20, exactly as g() expects.");

        System.out.println("g(new Square()):");
        try {
            ClientFunctions.g(new Square());
            System.out.println("  OK");
        } catch (AssertionError e) {
            System.out.println("  FAILED: " + e.getMessage());
        }
        System.out.println("Square passed every check IN ISOLATION -- it's a perfectly");
        System.out.println("consistent mathematical square. It breaks g() only because g()");
        System.out.println("makes a reasonable assumption about Rectangle that Square violates.");
        System.out.println("g() was never touched. It is still 'closed for modification.'");
        System.out.println("It broke anyway -- because OCP alone doesn't guarantee correctness,");
        System.out.println("LSP does.");
    }

    public static void main(String[] args) {
        run();
    }
}
