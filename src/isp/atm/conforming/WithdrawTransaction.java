package isp.atm.conforming;

public class WithdrawTransaction extends Transaction {
    private final WithdrawUI ui;

    public WithdrawTransaction(WithdrawUI ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.requestWithdrawAmount();
    }
}
