package ProgrammingChallenges;

public class StandardDeviation {
    public static void main(String[] args){

        int[] nums = new int[] {11,15,39,40,66,95,95,114,96,77,44,36,25}; // class values
        //int[] nums = new int[] {1,	2,	5,	10,	18,	21,	16,	34,	20,	13,	5,	4,	2}; // group 1 values
        //int[] nums = new int[] {1,	1,	7,	8,	18,	17,	21,	18,	14,	11,	18,	14,4}; // group 2 values
        //int[] nums = new int[] {2,	4,	13,	5,	14,	11,	27,	24,	24,	15,	6,	3,	2}; // group 3 values
        //int[] nums = new int[] {3,	2,	4,	9,	8,	23,	12,	25,	17,	23,	6,	8,	10}; // group 4 values
        //int[] nums = new int[] {4,6,10,8,8,23,19,13,21,15,9,7,7}; // group 5 values
        double Variance = 0, numDarts = 0, sumOfNums = 0;
        // numDarts = number of darts thrown overall
        // sumOfNums = darts with points
        for(int i = 1; i < nums.length+1; i++) {
            sumOfNums += nums[i - 1] * i;
            numDarts += nums[i - 1];
        }
        double firstNum = 1/Math.sqrt(numDarts);
        double mean = sumOfNums / numDarts;
        System.out.println("VALUES FOR GROUP 5");
        System.out.printf("Mean: %.2f\n",mean);
        for(int i = 1; i < nums.length + 1; i++) Variance += Math.pow((i - mean), 2) * nums[i - 1];
        double StandardDev = firstNum * Math.sqrt(Variance);
        System.out.printf("Standard Deviation: %.2f\n", StandardDev);
        double StandardErrorOfMean = StandardDev / Math.sqrt(numDarts);
        System.out.printf("Standard Error Of Mean: %.2f\n", StandardErrorOfMean);

        //Expected number of darts at each bin location.
        double[] dartsAtLocation = new double[nums.length];
        System.out.println("\nExpected Number Of Darts:");

        double firstPart = numDarts / (StandardDev * Math.sqrt(2*Math.PI));
        for(int i = 1; i < nums.length + 1; i++) {
            //if(i%2==1) {
                double secondPart = Math.exp((-Math.pow((i - mean), 2)) / (2 * Math.pow(StandardDev, 2)));
                dartsAtLocation[i - 1] = firstPart * secondPart;
                System.out.printf("Bin #%d: %.2f\n", i, firstPart * secondPart);
            //}
        }

        System.out.println("\nChi Squared Value: ");
        double[] chiSquaredValues = new double[nums.length];

        for(int i = 0; i < nums.length; i++){
            //if(i%2==0) {
                chiSquaredValues[i] = (Math.pow(dartsAtLocation[i] - nums[i], 2) / Math.sqrt(nums[i]));
                System.out.printf("Bin #%d: %.2f\n", i + 1, chiSquaredValues[i]);
            //}
        }
        System.out.println("\nReduced Chi Squared Value: (Supported)");

        for(int i = 0; i < nums.length; i++){
            //if(i%2==0)
                System.out.printf("Bin #%d: %.2f (%s)\n",i+1,chiSquaredValues[i]/10, chiSquaredValues[i]/10 > 1?"No":"Yes");
        }
    }
}
