package structural.decorator.conforming;

public class SimpleCoffee implements Coffee {
    @Override
    public String description() {
        return "Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
