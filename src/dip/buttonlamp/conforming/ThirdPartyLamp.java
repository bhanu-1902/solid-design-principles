package dip.buttonlamp.conforming;

// Simulates a vendor class we cannot modify -- different method
// names, no knowledge of ButtonClient, source not ours to edit.
public class ThirdPartyLamp {
    public void illuminate() {
        System.out.println("ThirdPartyLamp: illuminated");
    }

    public void darken() {
        System.out.println("ThirdPartyLamp: darkened");
    }
}
