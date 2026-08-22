package lsp.container.violating;

public class ClientFunctions {
    // Written once, against Set<T> -- exactly the kind of code the
    // Open-Closed principle promises will keep working, unmodified,
    // no matter which Set<T> implementation it's handed.
    @SafeVarargs
    public static <T> void addAll(Set<T> set, T... items) {
        for (T item : items) {
            set.add(item);
        }
    }
}
