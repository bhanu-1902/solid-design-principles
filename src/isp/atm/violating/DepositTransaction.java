package isp.atm.violating;

// Depends on the WHOLE UI interface, even though it only ever calls
// requestDepositAmount(). A change to requestWithdrawAmount()'s
// signature still forces this class to recompile.
public class DepositTransaction extends Transaction {
    private final UI ui;

    public DepositTransaction(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.requestDepositAmount();
    }
}
