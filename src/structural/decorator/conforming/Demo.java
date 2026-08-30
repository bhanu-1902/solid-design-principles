package structural.decorator.conforming;

public class Demo {
    public static void run() {
        Coffee milkAndSugar = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println(milkAndSugar.description() + " = $" + milkAndSugar.cost());

        Coffee justSugar = new SugarDecorator(new SimpleCoffee());
        System.out.println(justSugar.description() + " = $" + justSugar.cost());

        System.out.println();
        System.out.println("Both combinations above used the same two decorator classes,");
        System.out.println("stacked differently -- no CoffeeWithSugar or");
        System.out.println("CoffeeWithMilkAndSugar subclass was needed.");
    }

    public static void main(String[] args) {
        run();
    }
}
