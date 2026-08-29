package creational.builder.conforming;

public class Demo {
    public static void run() {
        Computer office = new Computer.Builder("Intel i5", 16)
                .storageGb(512)
                .withWifi()
                .build();
        System.out.println(office);

        Computer gaming = StandardBuilds.gamingComputer();
        System.out.println(gaming);

        System.out.println();
        System.out.println("Every option above is named at the call site -- no positional");
        System.out.println("booleans to transpose. Adding withFingerprintReader() next week");
        System.out.println("touches only Computer/Builder; nothing above recompiles differently.");
    }

    public static void main(String[] args) {
        run();
    }
}
