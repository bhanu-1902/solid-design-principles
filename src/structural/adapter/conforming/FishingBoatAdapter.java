package structural.adapter.conforming;

// Wraps the incompatible FishingBoat and re-exposes it as a RowingBoat.
// Captain depends only on RowingBoat (DIP); a new incompatible boat type
// is a new adapter class, and Captain never changes (OCP). This has to
// actually make the boat move forward when row() is called, or it would
// violate RowingBoat's implicit contract the same way
// lsp.rectangle.violating.Square broke Rectangle's -- an adapter that
// doesn't honor the target interface's behavior isn't a real substitute.
public class FishingBoatAdapter implements RowingBoat {
    private final FishingBoat fishingBoat;

    public FishingBoatAdapter(FishingBoat fishingBoat) {
        this.fishingBoat = fishingBoat;
    }

    @Override
    public void row() {
        fishingBoat.sail();
    }
}
