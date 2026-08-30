package structural.decorator.violating;

public class CoffeeWithMilk extends SimpleCoffee {
    @Override
    public String description() {
        return super.description() + " + Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}
