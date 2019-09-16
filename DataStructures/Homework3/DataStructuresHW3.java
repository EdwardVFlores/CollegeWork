package DataStructures;

public class DataStructuresHW3 extends Statistician {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Statistician s1 = new Statistician();
        Statistician s2 = new Statistician();

        //Putting values in s1 and s2
        for(int i = 0; i < nums.length; i++) if(i%2==0) s1.nextNumber(nums[i]);
        for(int i = 0; i < nums.length; i++) if(i%2==1) s2.nextNumber(nums[i]);


        //
        System.out.println("Numbers\ns1 Values:");
        for(int i : nums) if(i%2==1) System.out.print(i + " ");
        System.out.println();
        System.out.println("s2 Values:");
        for(int i : nums) if(i%2==0) System.out.print(i + " ");
        System.out.println("\n");

        // s1 + s2
        System.out.println("s1 & s2 added with values \n" + Statistician.add(s1,s2).toString());

        // null + s2
        System.out.println("null + s2 values\n" + Statistician.add(null,s2).toString());

        // s1 + null
        System.out.println("s1 values + null\n" + Statistician.add(s1, null).toString());

        // null + null
        System.out.println("null + null\n" + Statistician.add(null,null).toString());

        // Statisticians with no values
        Statistician s3 = new Statistician();
        Statistician s4 = new Statistician();

        // s3 + s4
        System.out.println("s3 no values + s4 no values\n"+ Statistician.add(s3,s4).toString());

        //Adding s7 with s1
        System.out.println("s1 values + s3 no values\n" + Statistician.add(s1,s3));
    }
}