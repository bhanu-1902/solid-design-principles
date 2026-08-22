package solid;

// SRP: exactly one reason to change -- how a check is ORCHESTRATED.
// It does not know how roles are stored, how a policy decides, or how
// audit entries are persisted.
//
// DIP: all three collaborators are abstractions, supplied through the
// constructor. This high-level module depends on nothing concrete.
public class AccessChecker {
    private final UserRepository users;
    private final AccessPolicy policy;
    private final AuditSink audit;

    public AccessChecker(UserRepository users, AccessPolicy policy, AuditSink audit) {
        this.users = users;
        this.policy = policy;
        this.audit = audit;
    }

    public boolean check(String userId, String action, String resource) {
        String role = users.roleOf(userId);
        boolean allowed = policy.isAllowed(userId, role, action, resource);
        audit.record(userId + " (" + role + ") " + action + " " + resource
                + " -> " + (allowed ? "ALLOWED" : "DENIED"));
        return allowed;
    }
}
