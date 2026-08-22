package lsp.container.conforming;

public class Demo {
    public static void run() {
        Set<String> names = new SimpleSet<>();
        names.add("Harshit");
        printAll("names", names);

        PersistentSet people = new PersistentSet();
        people.add(new PersistentObject("Harshit"));
        printAll("people", people);

        System.out.println("Both go through the same printAll(Container<T>) unmodified.");
        System.out.println("Try people.add(\"not persistent\") yourself: it's a COMPILE error");
        System.out.println("here, not a runtime ClassCastException like in lsp.container.violating.");
    }

    private static <T> void printAll(String label, Container<T> c) {
        System.out.print(label + ": ");
        for (T t : c) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        run();
    }
}
