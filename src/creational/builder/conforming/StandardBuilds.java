package creational.builder.conforming;

// The classic GoF "Director" role: a place that knows a few common recipes
// and drives the Builder through them, so callers who just want "a gaming
// PC" don't need to know which options that implies. Modern Java often
// folds the Director into the client instead (see Demo.run() building an
// office PC by hand) -- both are still the Builder pattern; this class
// exists to show the recipe form explicitly.
public class StandardBuilds {
    public static Computer gamingComputer() {
        return new Computer.Builder("Intel i9", 32)
                .storageGb(1024)
                .withGpu()
                .withWifi()
                .build();
    }

    public static Computer budgetOffice() {
        return new Computer.Builder("Intel i3", 8)
                .build();
    }
}
