package structural.adapter.violating;

public class Rowboat implements RowingBoat {
    @Override
    public void row() {
        System.out.println("The rowboat is rowing");
    }
}
