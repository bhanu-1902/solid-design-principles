package dip.copy.conforming;

public class KeyboardReader implements Reader {
    private static final String SIMULATED_INPUT = "HI";
    private int position = 0;

    @Override
    public int read() {
        if (position >= SIMULATED_INPUT.length()) {
            return -1;
        }
        return SIMULATED_INPUT.charAt(position++);
    }
}
