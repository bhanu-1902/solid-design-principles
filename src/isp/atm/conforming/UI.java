package isp.atm.conforming;

// Figure 6: the segregated interfaces are multiply-implemented back
// into one concrete UI -- exactly like TimedDoor did for Door and
// TimerClient. Only THIS class, and whatever boots the system, needs
// to know both interfaces exist together.
public class UI implements DepositUI, WithdrawUI {
    @Override
    public void requestDepositAmount() {
        System.out.println("UI: how much would you like to deposit?");
    }

    @Override
    public void requestWithdrawAmount() {
        System.out.println("UI: how much would you like to withdraw?");
    }
}
