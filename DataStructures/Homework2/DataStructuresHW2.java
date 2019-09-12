package DataStructures;

public class DataStructuresHW2 extends Statistician {
    public static void main(String[] args) {
        Statistician s = new Statistician();
        // Running object s with no values for test case
        // toString calls statistician methods needed for testing
        System.out.println("Statistician Without Values \n\n" + s.toString());
        // Inserting values into the Statistician object.
        s.nextNumber(-2.4);
        s.nextNumber(1.1);
        s.nextNumber(0.8);
        // Running object s with values for test case
        System.out.println("\nStatistician With Values \n\n" + s.toString());
    }
}