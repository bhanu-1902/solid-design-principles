package isp.atm.conforming;

public class Demo {
    // Martin's "polyad vs. monad" question: a function needing BOTH
    // capabilities could take one combined UI (monadic) or the two
    // thin interfaces separately (polyadic). The polyadic form is
    // preferable -- it doesn't force the function to depend on the
    // WHOLE UI, and it doesn't assume both capabilities must always
    // come from the same object.
    static void showBothPrompts(DepositUI d, WithdrawUI w) {
        d.requestDepositAmount();
        w.requestWithdrawAmount();
    }

    public static void run() {
        UI ui = new UI();
        new DepositTransaction(ui).execute();
        new WithdrawTransaction(ui).execute();

        System.out.println();
        System.out.println("A function needing both capabilities takes both thin interfaces");
        System.out.println("separately, not one fat UI (the 'polyadic' form Martin prefers):");
        showBothPrompts(ui, ui);

        System.out.println();
        System.out.println("DepositTransaction and WithdrawTransaction each depend on exactly");
        System.out.println("one interface. Changing WithdrawUI recompiles UI and Withdraw-");
        System.out.println("Transaction -- DepositTransaction is untouched.");
    }

    public static void main(String[] args) {
        run();
    }
}
