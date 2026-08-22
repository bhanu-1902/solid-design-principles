package dip.buttonlamp.violating;

public class Demo {
    public static void run() {
        Button button = new Button(new Lamp());
        button.press(true);
        button.press(false);

        System.out.println();
        System.out.println("Button is unusable for anything but a Lamp -- reusing it to");
        System.out.println("control a Motor would mean editing Button's source directly.");
    }

    public static void main(String[] args) {
        run();
    }
}
