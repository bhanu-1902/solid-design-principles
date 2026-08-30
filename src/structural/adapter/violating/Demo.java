package structural.adapter.violating;

public class Demo {
    public static void run() {
        Captain captain = new Captain();
        captain.move(new Rowboat());
        captain.move(new FishingBoat());

        System.out.println();
        System.out.println("Captain.move() had to be taught about FishingBoat by name.");
        System.out.println("A third incompatible boat means a third branch here.");
    }

    public static void main(String[] args) {
        run();
    }
}
