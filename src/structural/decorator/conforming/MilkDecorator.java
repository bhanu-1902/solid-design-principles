package structural.decorator.conforming;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String description() {
        return super.description() + " + Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}
