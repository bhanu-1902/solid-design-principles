package creational.singleton.violating;

import java.util.HashMap;
import java.util.Map;

// A "singleton" in name only: lazy, unsynchronized, and referenced by every
// caller as this concrete class directly. Two problems hide here: (1) under
// concurrent first use it can construct more than one instance (the classic
// double-checked-locking bug -- there is no locking at all here), and (2)
// every client depends on ConfigurationManager itself, not an abstraction --
// so DIP is violated the same way dip.copy.violating.Copy depended on
// concrete KeyboardReader/PrinterWriter. Swapping in a fake for a test means
// either touching real files or subclassing a class that was never designed
// for it.
public class ConfigurationManager {
    private static ConfigurationManager instance;

    private final Map<String, String> settings = new HashMap<>();

    private ConfigurationManager() {
        // Pretend this loads from a config file on disk.
        settings.put("env", "production");
        settings.put("retries", "3");
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager(); // racy under concurrent first use
        }
        return instance;
    }

    public String get(String key) {
        return settings.get(key);
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }
}
