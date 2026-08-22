package lsp.container.conforming;

public class PersistentObject {
    private final String data;

    public PersistentObject(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PersistentObject(" + data + ")";
    }
}
