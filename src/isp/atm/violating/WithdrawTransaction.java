package isp.atm.violating;

public class WithdrawTransaction extends Transaction {
    private final UI ui;

    public WithdrawTransaction(UI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.requestWithdrawAmount();
    }
}
