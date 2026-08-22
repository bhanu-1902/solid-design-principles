package synthesis;

import ocp.conforming.Circle;
import ocp.conforming.Square;
import ocp.conforming.Triangle;

import java.util.List;

// This is the inter-link, made executable rather than just argued in
// prose. Martin's own conclusion (end of the LSP article) is that LSP
// is what makes OCP SAFE to rely on. Three parts, in increasing order
// of how directly they touch real client code:
public class Demo {
    public static void run() {
        System.out.println("Part A: an OCP violation is often just a visible SYMPTOM.");
        System.out.println("ocp.conforming.Triangle already proves OCP -- it plugs into");
        System.out.println("ocp.conforming.ShapeDrawer with zero changes to existing code:");
        ocp.conforming.ShapeDrawer.drawAllShapes(
                List.of(new Circle(1, 0, 0), new Square(1, 0, 0), new Triangle(1, 1, 0, 0)));

        System.out.println();
        System.out.println("Route that SAME Triangle through an LSP-violating, typeid-style");
        System.out.println("dispatcher (lsp.rtti.ShapeTypeSwitch) instead, and OCP breaks:");
        lsp.rtti.ShapeTypeSwitch.drawShape(new Triangle(1, 1, 0, 0));
        System.out.println("(nothing printed above -- Triangle vanished. It isn't Triangle that");
        System.out.println(" violates LSP here; it's the dispatcher, because it can't treat an");
        System.out.println(" unfamiliar Shape the same way it treats a familiar one.)");

        System.out.println();
        System.out.println("Part B: an LSP violation in a TYPE breaks OCP for that type's clients.");
        System.out.println("lsp.rectangle.violating.ClientFunctions.g() is exactly the kind of");
        System.out.println("code OCP promises will keep working, unmodified, for every Rectangle");
        System.out.println("subtype:");
        lsp.rectangle.violating.Demo.run();

        System.out.println();
        System.out.println("Part C: restore LSP, and the OCP promise comes back.");
        System.out.println("lsp.rectangle.conforming makes Square a sibling of Rectangle, not a");
        System.out.println("subtype. Now ONE function works for both, unmodified:");
        lsp.rectangle.conforming.Demo.run();

        System.out.println();
        System.out.println("Conclusion: OCP is the goal -- extend behavior without modifying");
        System.out.println("working code. LSP is the constraint that makes relying on that goal");
        System.out.println("safe: every extension must be truly substitutable for what it");
        System.out.println("extends, or client code that was 'closed for modification' quietly");
        System.out.println("stops being correct. The container case study (lsp.container.*)");
        System.out.println("shows the same failure mode again, this time through generics and a");
        System.out.println("wrapped third-party dependency instead of geometry.");
    }

    public static void main(String[] args) {
        run();
    }
}
