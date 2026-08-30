package structural.adapter.conforming;

public class Demo {
    public static void run() {
        Captain captain = new Captain();
        captain.move(new Rowboat());
        captain.move(new FishingBoatAdapter(new FishingBoat()));

        System.out.println();
        System.out.println("Captain.move() only ever saw RowingBoat. FishingBoatAdapter is");
        System.out.println("the only thing that knows FishingBoat exists.");
    }

    public static void main(String[] args) {
        run();
    }
}
