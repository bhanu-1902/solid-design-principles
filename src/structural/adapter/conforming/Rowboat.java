package structural.adapter.conforming;

public class Rowboat implements RowingBoat {
    @Override
    public void row() {
        System.out.println("The rowboat is rowing");
    }
}
