package dip.copy.violating;

// Stands in for Listing 1's ReadKeyboard(). Java has no free
// functions, so this becomes a tiny class; simulated with a fixed
// character sequence so the demo is deterministic (no real stdin).
public class KeyboardReader {
    private static final String SIMULATED_INPUT = "HI";
    private int position = 0;

    public int read() {
        if (position >= SIMULATED_INPUT.length()) {
            return -1; // EOF
        }
        return SIMULATED_INPUT.charAt(position++);
    }
}
