package lsp.rectangle.conforming;

public class Demo {
    public static void run() {
        Rectangle r = new Rectangle();
        r.setWidth(5);
        r.setHeight(4);
        System.out.println("area(Rectangle 5x4) = " + ClientFunctions.area(r));

        Square s = new Square();
        s.setSide(4);
        System.out.println("area(Square side 4) = " + ClientFunctions.area(s));

        System.out.println("ONE function, ClientFunctions.area(Quadrilateral), works unmodified");
        System.out.println("for both -- because Square no longer promises anything it can't keep.");
    }

    public static void main(String[] args) {
        run();
    }
}
