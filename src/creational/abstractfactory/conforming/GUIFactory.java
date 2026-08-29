package creational.abstractfactory.conforming;

// The abstract factory: one abstraction that produces a whole FAMILY of
// related products (Button + Checkbox) guaranteed to match each other --
// a LightThemeFactory can never accidentally hand out a DarkCheckbox.
// Application depends on this interface and on Button/Checkbox, never on
// a concrete widget class (DIP), the same relationship
// dip.buttonlamp.conforming.ButtonClient has to Lamp/Motor.
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
