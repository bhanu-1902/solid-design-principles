package creational.abstractfactory.violating;

public class Demo {
    public static void run() {
        Application light = new Application("light");
        light.renderButton();
        light.renderCheckbox();

        Application dark = new Application("dark");
        dark.renderButton();
        dark.renderCheckbox();

        System.out.println("Application knows about all four concrete widget classes and");
        System.out.println("re-checks \"theme\" in every render method -- a third theme means");
        System.out.println("editing both methods, and it's easy to update one and miss the other.");
    }

    public static void main(String[] args) {
        run();
    }
}
