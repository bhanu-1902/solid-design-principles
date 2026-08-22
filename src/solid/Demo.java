package solid;

import java.util.Map;
import java.util.Set;

public class Demo {
    // ISP, made concrete: this function needs the policy capability
    // only. Because AccessPolicy is a thin, single-purpose interface,
    // nothing forces it to also depend on UserRepository or AuditSink.
    static void probePolicyDirectly(AccessPolicy policy) {
        System.out.println("  direct probe -> " + policy.isAllowed("u9", "guest", "read", "doc-1"));
    }

    public static void run() {
        UserRepository users = new InMemoryUserRepository(Map.of(
                "u1", "editor",
                "u2", "viewer"
        ));
        AuditSink audit = new ConsoleAuditSink();

        System.out.println("-- SRP + DIP: AccessChecker only orchestrates; it depends on");
        System.out.println("   UserRepository / AccessPolicy / AuditSink abstractions, never");
        System.out.println("   on a concrete class --");
        AccessPolicy rolePolicy = new RoleBasedAccessPolicy(Map.of(
                "editor", Set.of("read", "write"),
                "viewer", Set.of("read")
        ));
        AccessChecker checker = new AccessChecker(users, rolePolicy, audit);
        checker.check("u1", "write", "doc-42");
        checker.check("u2", "write", "doc-42");

        System.out.println();
        System.out.println("-- OCP: swap in a completely different AccessPolicy. AccessChecker");
        System.out.println("   itself is unmodified -- same class, new behavior --");
        AccessPolicy ownerPolicy = new ResourceOwnerAccessPolicy(Map.of("doc-42", "u2"));
        AccessChecker ownerChecker = new AccessChecker(users, ownerPolicy, audit);
        ownerChecker.check("u2", "delete", "doc-42");
        ownerChecker.check("u1", "delete", "doc-42");

        System.out.println();
        System.out.println("-- LSP: a policy that breaks the interface's implicit contract");
        System.out.println("   ('always returns a boolean') breaks AccessChecker, even though");
        System.out.println("   AccessChecker itself was never touched --");
        AccessPolicy flaky = new FlakyAccessPolicy(Map.of("editor", Set.of("read", "write")));
        AccessChecker flakyChecker = new AccessChecker(users, flaky, audit);
        try {
            flakyChecker.check("u2", "read", "doc-42"); // u2's role, "viewer", is unrecognized here
        } catch (IllegalStateException e) {
            System.out.println("  AccessChecker.check() threw: " + e.getMessage());
            System.out.println("  -> AccessChecker never catches this; it trusted the contract.");
        }

        System.out.println();
        System.out.println("-- ISP: UserRepository, AccessPolicy, and AuditSink are three thin");
        System.out.println("   interfaces, not one fat AccessControl interface --");
        probePolicyDirectly(rolePolicy);
        System.out.println("  (that call never touched UserRepository or AuditSink at all)");
    }

    public static void main(String[] args) {
        run();
    }
}
