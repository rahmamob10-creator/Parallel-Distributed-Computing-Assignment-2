import java.util.Arrays;

public class SymmetryApp {
    public static void main(String[] args) {
        System.out.println("--- Network Packet Sequence Symmetry Verification ---");

        int[] symmetricStream = {0x7E, 0xFF, 0x0A, 0xFF, 0x7E};
        int[] asymmetricStream = {0x7E, 0xFF, 0x0A, 0x0B, 0x7E};

        boolean res1 = PacketSymmetryChecker.isSymmetricSequence(symmetricStream);
        boolean res2 = PacketSymmetryChecker.isSymmetricSequence(asymmetricStream);

        System.out.println("Stream 1 " + Arrays.toString(symmetricStream) + " Is Symmetric: " + res1);
        System.out.println("Stream 2 " + Arrays.toString(asymmetricStream) + " Is Symmetric: " + res2);
    }
}
/**
 * Thread-Safety Verification & Optimization
 * Target Module: SymmetryApp.java
 */

// Execution Log Verification Updated
