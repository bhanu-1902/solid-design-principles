package creational.abstractfactory.conforming;

public class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("[Dark Button]");
    }
}
