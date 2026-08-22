package isp.atm.violating;

// Figure 5's fat interface: every transaction type's needs are piled
// into ONE UI interface, whether a given Transaction uses them or not.
public interface UI {
    void requestDepositAmount();
    void requestWithdrawAmount();
}
