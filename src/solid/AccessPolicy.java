package solid;

// OCP's extension point: new access rules are added by writing a new
// AccessPolicy, never by editing AccessChecker. Also the LSP contract
// every implementation below must honor: given the same four inputs,
// always return a boolean -- never throw for a merely-unrecognized
// role or resource.
public interface AccessPolicy {
    boolean isAllowed(String userId, String role, String action, String resource);
}
