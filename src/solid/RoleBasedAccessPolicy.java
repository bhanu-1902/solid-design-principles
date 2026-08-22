package solid;

import java.util.Map;
import java.util.Set;

public class RoleBasedAccessPolicy implements AccessPolicy {
    private final Map<String, Set<String>> allowedActionsByRole;

    public RoleBasedAccessPolicy(Map<String, Set<String>> allowedActionsByRole) {
        this.allowedActionsByRole = allowedActionsByRole;
    }

    @Override
    public boolean isAllowed(String userId, String role, String action, String resource) {
        Set<String> allowed = allowedActionsByRole.get(role);
        // LSP-compliant: an unrecognized role is a normal "no", not an
        // error. The AccessPolicy contract promises a boolean, always.
        return allowed != null && allowed.contains(action);
    }
}
