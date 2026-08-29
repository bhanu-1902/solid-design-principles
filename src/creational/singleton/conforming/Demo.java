package creational.singleton.conforming;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    // High-level class depends on the Configuration abstraction only -- it
    // never mentions ConfigurationManager by name. Swap in any Configuration
    // (including a test fake) with zero changes here.
    static class RetryPolicy {
        private final Configuration config;

        RetryPolicy(Configuration config) {
            this.config = config;
        }

        int maxRetries() {
            return Integer.parseInt(config.get("retries"));
        }
    }

    public static void run() {
        Configuration config = ConfigurationManager.getInstance();
        RetryPolicy policy = new RetryPolicy(config);
        System.out.println("real config -> maxRetries = " + policy.maxRetries());

        Configuration fake = new Configuration() {
            private final Map<String, String> data = new HashMap<>(Map.of("retries", "99"));

            @Override
            public String get(String key) {
                return data.get(key);
            }

            @Override
            public void set(String key, String value) {
                data.put(key, value);
            }
        };
        System.out.println("fake config in a test -> maxRetries = " + new RetryPolicy(fake).maxRetries());
        System.out.println("RetryPolicy never changed -- it only ever knew about Configuration.");
    }

    public static void main(String[] args) {
        run();
    }
}
