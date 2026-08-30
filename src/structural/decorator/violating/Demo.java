package structural.decorator.violating;

public class Demo {
    public static void run() {
        Coffee coffee = new CoffeeWithMilkAndSugar();
        System.out.println(coffee.description() + " = $" + coffee.cost());

        System.out.println();
        System.out.println("Want sugar without milk? That's a new subclass. Want whipped");
        System.out.println("cream too? That's several more subclasses to cover every");
        System.out.println("combination it can now appear in.");
    }

    public static void main(String[] args) {
        run();
    }
}
