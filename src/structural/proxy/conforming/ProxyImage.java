package structural.proxy.conforming;

// Same interface as RealImage, so callers can't tell the difference --
// they depend on Image only (DIP), the same relationship
// creational.singleton.conforming's callers have to Configuration. The
// proxy is the one place that decides WHEN the expensive RealImage
// actually gets built, which is exactly the indirection point .violating
// was missing.
public class ProxyImage implements Image {
    private final String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
