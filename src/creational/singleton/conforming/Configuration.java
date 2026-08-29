package creational.singleton.conforming;

// The abstraction callers actually depend on. Any high-level class that
// needs configuration should take a Configuration, not a
// ConfigurationManager -- exactly DIP's "depend on abstractions" (see
// dip.copy.conforming.Reader/Writer). It also makes the Singleton
// substitutable with a fake in tests, which the concrete-class version in
// .violating cannot offer.
public interface Configuration {
    String get(String key);
    void set(String key, String value);
}
