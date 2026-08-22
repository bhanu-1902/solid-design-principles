package solid;

import java.util.Map;

// DIP: a low-level DETAIL. It depends on the UserRepository
// abstraction (by implementing it); nothing depends on THIS class by
// name except whatever wires the system together.
public class InMemoryUserRepository implements UserRepository {
    private final Map<String, String> rolesByUser;

    public InMemoryUserRepository(Map<String, String> rolesByUser) {
        this.rolesByUser = rolesByUser;
    }

    @Override
    public String roleOf(String userId) {
        return rolesByUser.getOrDefault(userId, "guest");
    }
}
