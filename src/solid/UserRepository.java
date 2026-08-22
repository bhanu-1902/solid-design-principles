package solid;

// ISP: a thin, single-purpose interface. A test that only needs to
// fake user lookups never has to also fake auditing or policy logic.
public interface UserRepository {
    String roleOf(String userId);
}
