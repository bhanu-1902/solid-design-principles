package creational.abstractfactory.conforming;

public class DarkCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("[Dark Checkbox]");
    }
}
