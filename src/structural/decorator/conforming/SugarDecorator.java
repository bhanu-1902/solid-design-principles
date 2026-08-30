package structural.decorator.conforming;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String description() {
        return super.description() + " + Sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 0.25;
    }
}
