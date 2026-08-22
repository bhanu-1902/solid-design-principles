package isp.atm.violating;

public class ConsoleUI implements UI {
    @Override
    public void requestDepositAmount() {
        System.out.println("UI: how much would you like to deposit?");
    }

    @Override
    public void requestWithdrawAmount() {
        System.out.println("UI: how much would you like to withdraw?");
    }
}
