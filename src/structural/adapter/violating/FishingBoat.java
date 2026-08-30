package structural.adapter.violating;

// A perfectly good boat with an incompatible interface -- and it
// shouldn't have to know RowingBoat exists just to be usable by a Captain.
public class FishingBoat {
    public void sail() {
        System.out.println("The fishing boat is sailing");
    }
}
