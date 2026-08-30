package structural.facade.conforming;

public class HardDrive {
    public byte[] read(long lba, int size) {
        System.out.println("HardDrive: reading " + size + " bytes from sector " + lba);
        return new byte[size];
    }
}
