package lsp.container.violating;

public class Demo {
    public static void run() {
        Set<PersistentObject> people = new PersistentSet<>();
        ClientFunctions.addAll(people, new PersistentObject("Harshit"));
        System.out.println("addAll() worked fine for a well-formed PersistentObject.");

        System.out.println("Now call the SAME addAll(), against the SAME Set<T> interface,");
        System.out.println("with a plain String instead:");
        try {
            Set<Object> mixed = new PersistentSet<>();
            ClientFunctions.addAll(mixed, "not persistent");
        } catch (ClassCastException e) {
            System.out.println("  FAILED at runtime: " + e);
        }
        System.out.println("addAll() never changed. It broke because PersistentSet silently");
        System.out.println("narrows what Set<T> promised -- an LSP violation surfacing as a");
        System.out.println("runtime OCP violation, far from where the real mistake was made.");
    }

    public static void main(String[] args) {
        run();
    }
}
