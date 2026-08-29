package creational.abstractfactory.conforming;

public class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("[Light Button]");
    }
}
