package ocp.encapsulation;

// Listing 7, as Martin wrote it: `status` is public. His argument is
// that even though its TYPE will never change, one misbehaving
// client writing to it can silently break every other client.
public class Device {
    public boolean status;
}
