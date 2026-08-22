package srp.rectangle.conforming;

// The other reason to change: how a rectangle is drawn. This class
// depends on GeometricRectangle (it needs width/height to render) --
// but the dependency runs only one way. GeometricRectangle has no
// idea this class exists, so a rendering change never touches it.
public class RectangleRenderer {
    public void draw(GeometricRectangle r) {
        System.out.printf("Drawing %sx%s rectangle on screen%n", r.getWidth(), r.getHeight());
    }
}
