package structural.proxy.conforming;

public class Demo {
    public static void run() {
        System.out.println("Building gallery (no loading yet -- these are proxies):");
        Image[] gallery = {
                new ProxyImage("photo1.jpg"),
                new ProxyImage("photo2.jpg"),
                new ProxyImage("photo3.jpg")
        };

        System.out.println();
        System.out.println("Only displaying the first one:");
        gallery[0].display();

        System.out.println();
        System.out.println("photo2.jpg and photo3.jpg were never loaded from disk.");
    }

    public static void main(String[] args) {
        run();
    }
}
