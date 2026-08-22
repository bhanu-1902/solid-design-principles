package solid;

import java.util.Map;

// OCP in action: added AFTER RoleBasedAccessPolicy shipped. Zero
// changes to AccessChecker, RoleBasedAccessPolicy, or any interface.
public class ResourceOwnerAccessPolicy implements AccessPolicy {
    private final Map<String, String> ownerByResource;

    public ResourceOwnerAccessPolicy(Map<String, String> ownerByResource) {
        this.ownerByResource = ownerByResource;
    }

    @Override
    public boolean isAllowed(String userId, String role, String action, String resource) {
        return userId != null && userId.equals(ownerByResource.get(resource));
    }
}
