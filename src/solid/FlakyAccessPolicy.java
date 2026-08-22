package solid;

import java.util.Map;
import java.util.Set;

// LSP VIOLATION, planted on purpose: throws for an unrecognized role
// instead of honoring the "always returns a boolean" contract every
// other AccessPolicy keeps. AccessChecker was written trusting that
// contract and never expects isAllowed() to throw.
public class FlakyAccessPolicy implements AccessPolicy {
    private final Map<String, Set<String>> allowedActionsByRole;

    public FlakyAccessPolicy(Map<String, Set<String>> allowedActionsByRole) {
        this.allowedActionsByRole = allowedActionsByRole;
    }

    @Override
    public boolean isAllowed(String userId, String role, String action, String resource) {
        if (!allowedActionsByRole.containsKey(role)) {
            throw new IllegalStateException("unrecognized role: " + role);
        }
        return allowedActionsByRole.get(role).contains(action);
    }
}
