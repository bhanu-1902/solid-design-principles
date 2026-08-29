package creational.abstractfactory.conforming;

public class Demo {
    public static void run() {
        new Application(new LightThemeFactory()).render();
        new Application(new DarkThemeFactory()).render();

        System.out.println();
        System.out.println("Application never named LightButton, DarkButton, LightCheckbox,");
        System.out.println("or DarkCheckbox -- only GUIFactory, Button, and Checkbox. A new");
        System.out.println("theme is a new GUIFactory; Application is untouched.");
    }

    public static void main(String[] args) {
        run();
    }
}
