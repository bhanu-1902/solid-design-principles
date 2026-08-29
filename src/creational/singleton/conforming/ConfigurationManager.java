package creational.singleton.conforming;

import java.util.HashMap;
import java.util.Map;

// Initialization-on-demand holder idiom: the JVM's class-loading guarantees
// make this lazy AND thread-safe with no explicit locking, unlike
// .violating's getInstance(). The class still controls its own single
// instance (that's the Singleton pattern itself) but now implements
// Configuration, so it satisfies DIP for every caller that asks for the
// interface instead of this class by name.
public final class ConfigurationManager implements Configuration {
    private final Map<String, String> settings = new HashMap<>();

    private ConfigurationManager() {
        settings.put("env", "production");
        settings.put("retries", "3");
    }

    private static final class Holder {
        static final ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    public static Configuration getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public String get(String key) {
        return settings.get(key);
    }

    @Override
    public void set(String key, String value) {
        settings.put(key, value);
    }
}
