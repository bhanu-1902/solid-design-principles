package lsp.rectangle.violating;

// Keeps the "always a mathematical square" invariant intact in
// isolation -- but its setWidth/setHeight postconditions are WEAKER
// than Rectangle's, not stronger, which is what Meyer's rule for
// contract redefinition actually requires. That's the LSP violation,
// stated precisely.
public class Square extends Rectangle {
    @Override
    public void setWidth(double w) {
        super.setWidth(w);
        super.setHeight(w); // also changes height -- Rectangle never promised this
    }

    @Override
    public void setHeight(double h) {
        super.setHeight(h);
        super.setWidth(h); // also changes width -- Rectangle never promised this
    }
}
