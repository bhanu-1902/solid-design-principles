package structural.decorator.violating;

// Getting "just sugar, no milk" means yet ANOTHER subclass
// (CoffeeWithSugar extends SimpleCoffee), and every new topping multiplies
// the number of subclasses needed to cover every combination -- classic
// combinatorial subclass explosion (violates OCP: each new topping forces
// new classes for every combination it can appear in, not an isolated
// addition).
public class CoffeeWithMilkAndSugar extends CoffeeWithMilk {
    @Override
    public String description() {
        return super.description() + " + Sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 0.25;
    }
}
