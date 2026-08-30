package structural.adapter.violating;

// Captain is written against RowingBoat -- until a FishingBoat shows up.
// Rather than an adapter, this special-cases it directly: Captain now has
// to know FishingBoat exists and which method it uses instead of row()
// (violates DIP), and a third incompatible boat type means a third branch
// here (violates OCP).
public class Captain {
    public void move(Object boat) {
        if (boat instanceof RowingBoat rowingBoat) {
            rowingBoat.row();
        } else if (boat instanceof FishingBoat fishingBoat) {
            fishingBoat.sail();
        } else {
            throw new IllegalArgumentException("Captain doesn't know how to move this boat");
        }
    }
}
