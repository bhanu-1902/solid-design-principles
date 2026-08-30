public class App {
    public static void main(String[] args) {
        System.out.println("SOLID Principles -- C++ -> Java conversions of Robert C. Martin's examples");

        // ============================== S ==============================
        header("1. Rectangle: draw()+area() bundled (VIOLATES SRP)");
        srp.rectangle.violating.Demo.run();

        header("2. Rectangle: geometry vs. rendering separated (CONFORMS to SRP)");
        srp.rectangle.conforming.Demo.run();

        header("3. Modem: fat dial/hangup/send/recv interface (VIOLATES SRP)");
        srp.modem.violating.Demo.run();

        header("4. Modem: Connection vs. DataChannel separated (CONFORMS to SRP)");
        srp.modem.conforming.Demo.run();

        // ============================== O ==============================
        header("5. Procedural switch-on-type (VIOLATES OCP) -- OCP Listing 1");
        ocp.procedural.Demo.run();

        header("6. Polymorphic OOD solution (CONFORMS to OCP) -- OCP Listing 2");
        ocp.conforming.Demo.run();

        header("7. Ordering via hard-coded instanceof (VIOLATES OCP) -- OCP Listings 3-5");
        ocp.ordering.violating.Demo.run();

        header("8. Ordering via table-driven policy (CONFORMS to OCP) -- OCP Listing 6");
        ocp.ordering.conforming.Demo.run();

        header("9. Public fields: Device vs. Time -- OCP Listings 7-8");
        ocp.encapsulation.Demo.run();

        header("10. RTTI that VIOLATES OCP -- OCP Listing 9");
        ocp.rtti.violating.Demo.run();

        header("11. RTTI that does NOT violate OCP -- OCP Listing 10");
        ocp.rtti.conforming.Demo.run();

        // ============================== L ==============================
        header("12. typeid-based dispatch (VIOLATES LSP) -- LSP's DrawShape example");
        lsp.rtti.Demo.run();

        header("13. Square breaks a Rectangle client (VIOLATES LSP) -- the Rectangle/Square example");
        lsp.rectangle.violating.Demo.run();

        header("14. Square & Rectangle as siblings (CONFORMS to LSP)");
        lsp.rectangle.conforming.Demo.run();

        header("15. PersistentSet unsafely narrows Set<T> (VIOLATES LSP) -- the container case study");
        lsp.container.violating.Demo.run();

        header("16. PersistentSet as a sibling container (CONFORMS to LSP)");
        lsp.container.conforming.Demo.run();

        header("17. Synthesis -- how LSP and OCP interlock");
        synthesis.Demo.run();

        // ============================== I ==============================
        header("18. Door polluted with TimerClient (VIOLATES ISP) -- the Door/TimedDoor example");
        isp.door.violating.Demo.run();

        header("19. Door and TimerClient separated (CONFORMS to ISP)");
        isp.door.conforming.Demo.run();

        header("20. One fat UI interface for every transaction (VIOLATES ISP) -- the ATM UI example");
        isp.atm.violating.Demo.run();

        header("21. Segregated DepositUI / WithdrawUI (CONFORMS to ISP)");
        isp.atm.conforming.Demo.run();

        // ============================== D ==============================
        header("22. Copy hard-wired to concrete Reader/Writer (VIOLATES DIP) -- the Copy program");
        dip.copy.violating.Demo.run();

        header("23. Copy depending on Reader/Writer abstractions (CONFORMS to DIP)");
        dip.copy.conforming.Demo.run();

        header("24. Button directly coupled to Lamp (VIOLATES DIP) -- the Button/Lamp example");
        dip.buttonlamp.violating.Demo.run();

        header("25. Button depending on abstract ButtonClient (CONFORMS to DIP)");
        dip.buttonlamp.conforming.Demo.run();

        // ============================ SOLID =============================
        header("26. SOLID capstone -- a small RBAC system using all five principles together");
        solid.Demo.run();

        // =================== CREATIONAL PATTERNS (GoF) ===================
        header("27. Singleton: unsynchronized, concrete-class global state (VIOLATES DIP)");
        creational.singleton.violating.Demo.run();

        header("28. Singleton: thread-safe holder behind a Configuration interface (RESTORES DIP)");
        creational.singleton.conforming.Demo.run();

        header("29. Factory Method: switch-style creation in one method (VIOLATES OCP)");
        creational.factorymethod.violating.Demo.run();

        header("30. Factory Method: creation deferred to subclasses (CONFORMS to OCP/DIP)");
        creational.factorymethod.conforming.Demo.run();

        header("31. Builder: telescoping constructors (VIOLATES SRP/OCP)");
        creational.builder.violating.Demo.run();

        header("32. Builder: fluent Builder separates assembly from representation (CONFORMS to SRP/OCP)");
        creational.builder.conforming.Demo.run();

        header("33. Abstract Factory: theme re-checked in every render method (VIOLATES OCP/DIP)");
        creational.abstractfactory.violating.Demo.run();

        header("34. Abstract Factory: GUIFactory produces a matched widget family (CONFORMS to OCP/DIP)");
        creational.abstractfactory.conforming.Demo.run();

        header("35. Prototype: re-running expensive setup at every spawn site (VIOLATES OCP/DIP)");
        creational.prototype.violating.Demo.run();

        header("36. Prototype: cloning a registered prototype (CONFORMS to OCP/DIP)");
        creational.prototype.conforming.Demo.run();

        header("37. Factory: the same type->class decision duplicated at every call site (VIOLATES DIP)");
        creational.factory.violating.Demo.run();

        header("38. Factory: one centralized CoinFactory (RESTORES DIP; partial OCP -- compare to #30)");
        creational.factory.conforming.Demo.run();

        // =================== STRUCTURAL PATTERNS (GoF) ====================
        header("39. Adapter: Captain special-cases FishingBoat by name (VIOLATES OCP/DIP)");
        structural.adapter.violating.Demo.run();

        header("40. Adapter: FishingBoatAdapter re-exposes it as a RowingBoat (CONFORMS to OCP/DIP)");
        structural.adapter.conforming.Demo.run();

        header("41. Decorator: a new subclass per topping combination (VIOLATES OCP)");
        structural.decorator.violating.Demo.run();

        header("42. Decorator: toppings stack as wrappers at runtime (CONFORMS to OCP)");
        structural.decorator.conforming.Demo.run();

        header("43. Facade: boot sequence duplicated across two client methods (VIOLATES DIP/DRY)");
        structural.facade.violating.Demo.run();

        header("44. Facade: ComputerFacade owns the boot sequence in one place (CONFORMS to DIP)");
        structural.facade.conforming.Demo.run();

        header("45. Composite: client recurses by hand over two separate child lists (VIOLATES OCP)");
        structural.composite.violating.Demo.run();

        header("46. Composite: File and Directory answer getSizeKb() uniformly (CONFORMS to OCP/DIP)");
        structural.composite.conforming.Demo.run();

        header("47. Proxy: every image loads eagerly, used or not (VIOLATES DIP)");
        structural.proxy.violating.Demo.run();

        header("48. Proxy: ProxyImage defers loading until first display() (CONFORMS to DIP)");
        structural.proxy.conforming.Demo.run();

        header("49. Bridge: one class per (shape, color) pair (VIOLATES OCP)");
        structural.bridge.violating.Demo.run();

        header("50. Bridge: Shape holds a Color instead of extending one (CONFORMS to OCP/DIP)");
        structural.bridge.conforming.Demo.run();

        header("51. Flyweight: every tree duplicates its own texture data (wasteful, poor OCP for growth)");
        structural.flyweight.violating.Demo.run();

        header("52. Flyweight: TreeFactory shares one TreeType per species (CONFORMS to DIP)");
        structural.flyweight.conforming.Demo.run();

        System.out.println();
        System.out.println("Done. See README.md for the full listing map and exercises.");
        System.out.println("Run any single section standalone, e.g.:");
        System.out.println("  java -cp out solid.Demo");
        System.out.println("  java -cp out dip.buttonlamp.conforming.Demo");
        System.out.println("  java -cp out creational.abstractfactory.conforming.Demo");
        System.out.println("  java -cp out structural.bridge.conforming.Demo");
    }

    private static void header(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
