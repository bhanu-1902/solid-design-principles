package lsp.rtti;

import ocp.conforming.Circle;
import ocp.conforming.Shape;
import ocp.conforming.Square;

// Martin's DrawShape example (typeid(s) == typeid(Square) then
// static_cast). Java's nearest equivalent of typeid-equality is an
// EXACT class check -- getClass() == X.class -- which is stricter
// than instanceof (it rejects subclasses of X, not just non-X types).
//
// Reuses ocp.conforming.Shape/Circle/Square from the OCP part on purpose:
// that Shape already has a perfectly good virtual draw(). This
// function is not just an LSP violation, it's an unnecessary one --
// polymorphism already solved this problem.
public class ShapeTypeSwitch {
    public static void drawShape(Shape s) {
        if (s.getClass() == Square.class) {
            ((Square) s).draw();
        } else if (s.getClass() == Circle.class) {
            ((Circle) s).draw();
        }
        // Anything else -- e.g. conforming.Triangle -- falls through
        // and silently draws nothing.
    }
}
