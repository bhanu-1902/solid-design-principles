package creational.abstractfactory.violating;

// Every method that renders a widget re-checks the theme and re-lists
// every concrete class that theme could mean. Two symptoms: (1) this
// class depends on LightButton/DarkButton/LightCheckbox/DarkCheckbox
// directly -- four concrete classes, zero abstractions (violates DIP);
// (2) adding a third theme means finding and editing every one of these
// if/else chains, and it is easy to update one and forget another,
// producing a UI that mixes themes inconsistently (violates OCP).
public class Application {
    private final String theme;

    public Application(String theme) {
        this.theme = theme;
    }

    public void renderButton() {
        if (theme.equals("dark")) {
            new DarkButton().render();
        } else {
            new LightButton().render();
        }
    }

    public void renderCheckbox() {
        if (theme.equals("dark")) {
            new DarkCheckbox().render();
        } else {
            new LightCheckbox().render();
        }
    }
}
