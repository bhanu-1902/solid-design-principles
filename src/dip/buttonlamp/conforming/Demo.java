package dip.buttonlamp.conforming;

public class Demo {
    public static void run() {
        System.out.println("Button controlling a Lamp:");
        ButtonImplementation lampButton = new ButtonImplementation(new Lamp());
        lampButton.press(true);
        lampButton.press(false);

        System.out.println();
        System.out.println("SAME Button class, now controlling a Motor -- zero changes to Button:");
        ButtonImplementation motorButton = new ButtonImplementation(new Motor());
        motorButton.press(true);
        motorButton.press(false);

        System.out.println();
        System.out.println("A vendor's ThirdPartyLamp, which we cannot modify, via an Adapter:");
        ButtonImplementation adaptedButton =
                new ButtonImplementation(new LampAdapter(new ThirdPartyLamp()));
        adaptedButton.press(true);
        adaptedButton.press(false);
    }

    public static void main(String[] args) {
        run();
    }
}
