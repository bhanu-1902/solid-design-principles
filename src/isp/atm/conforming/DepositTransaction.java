package isp.atm.conforming;

// Depends on DepositUI ONLY. WithdrawUI could change completely and
// this class would never know or care -- no recompile, no risk.
public class DepositTransaction extends Transaction {
    private final DepositUI ui;

    public DepositTransaction(DepositUI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.requestDepositAmount();
    }
}
