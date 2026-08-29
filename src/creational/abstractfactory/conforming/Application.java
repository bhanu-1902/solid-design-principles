package creational.abstractfactory.conforming;

// No theme string, no if/else, no concrete widget class in sight. This
// class is closed for modification (OCP) with respect to new themes -- a
// HighContrastThemeFactory shows up later as one new file, and Application
// never changes to support it.
public class Application {
    private final GUIFactory factory;

    public Application(GUIFactory factory) {
        this.factory = factory;
    }

    public void render() {
        factory.createButton().render();
        factory.createCheckbox().render();
    }
}
