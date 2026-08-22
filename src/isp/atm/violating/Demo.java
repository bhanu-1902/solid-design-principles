package isp.atm.violating;

public class Demo {
    public static void run() {
        UI ui = new ConsoleUI();
        new DepositTransaction(ui).execute();
        new WithdrawTransaction(ui).execute();

        System.out.println();
        System.out.println("DepositTransaction is typed to depend on the FULL UI interface --");
        System.out.println("it never calls requestWithdrawAmount(), but a signature change to");
        System.out.println("that method still forces DepositTransaction to recompile.");
    }

    public static void main(String[] args) {
        run();
    }
}
