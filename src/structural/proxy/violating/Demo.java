package structural.proxy.violating;

// Every image in the gallery is loaded from disk immediately, whether or
// not it's ever displayed -- there's no indirection point where "create
// on first real use" could live. Client code holds RealImage directly
// (violates DIP too: any future access check or caching has to be added
// at every call site that constructs one, not in one place).
public class Demo {
    public static void run() {
        System.out.println("Building gallery (loads every image up front):");
        Image[] gallery = {
                new RealImage("photo1.jpg"),
                new RealImage("photo2.jpg"),
                new RealImage("photo3.jpg")
        };

        System.out.println();
        System.out.println("Only displaying the first one:");
        gallery[0].display();

        System.out.println();
        System.out.println("photo2.jpg and photo3.jpg were loaded from disk for nothing.");
    }

    public static void main(String[] args) {
        run();
    }
}
