package structural.decorator.violating;

public class SimpleCoffee extends Coffee {
    @Override
    public String description() {
        return "Coffee";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
