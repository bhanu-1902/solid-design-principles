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

        System.out.println();
        System.out.println("Done. See README.md for the full listing map and exercises.");
        System.out.println("Run any single section standalone, e.g.:");
        System.out.println("  java -cp out solid.Demo");
        System.out.println("  java -cp out dip.buttonlamp.conforming.Demo");
        System.out.println("  java -cp out creational.abstractfactory.conforming.Demo");
    }

    private static void header(String title) {
        System.out.println();
        System.out.println("=== " + title + " ===");
    }
}
