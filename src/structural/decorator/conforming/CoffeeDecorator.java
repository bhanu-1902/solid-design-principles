package structural.decorator.conforming;

// Wraps a Coffee instead of extending one -- composition instead of
// inheritance. Every combination of toppings is now a runtime choice of
// which decorators to stack, not a compile-time subclass someone had to
// write in advance. Adding a topping means one new subclass of this
// class, which never itself changes (OCP), and everything downstream
// still depends only on Coffee (DIP).
public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    protected CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String description() {
        return decoratedCoffee.description();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}
