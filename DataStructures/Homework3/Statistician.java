package DataStructures;

public class Statistician {
    private int Length;
    private double LastNumber, Mean, Sum, SmallestNum, LargestNum;

    public Statistician(){
        Length = 0;
        Sum = 0;
        SmallestNum = Double.MAX_VALUE;
        LargestNum = Double.MIN_VALUE;
    }

    public Statistician(Statistician s1){
        this.Length = s1.getLength();
        this.LastNumber = s1.getLastNumber();
        this.Mean = s1.getMean();
        this.Sum = s1.getSum();
        this.SmallestNum = s1.getSmallestNum();
        this.LargestNum = s1.getLargestNum();
    }

    public void nextNumber(double num) {
        ++Length;
        LastNumber = num;
        Sum += num;
        SmallestNum = Math.min(SmallestNum, num);
        LargestNum = Math.max(LargestNum, num);
        Mean = Sum / Length;
    }

    public int getLength() {
        return Length;
    }

    public double getSum() {
        return Sum;
    }

    public double getLastNumber() {
        return getLength() > 0 ? LastNumber : Double.NaN;
    }

    public double getMean() {
        return getLength() > 0 ? Mean : Double.NaN;
    }

    public double getSmallestNum() {
        return getLength() > 0 ? SmallestNum : Double.NaN;
    }

    public double getLargestNum() {
        return getLength() > 0 ? LargestNum : Double.NaN;
    }

    public static Statistician add(Statistician s1, Statistician s2){
        if(s1 == null && s2 == null) return new Statistician();
        else if (s1 == null || s2 == null) return s1 == null ? new Statistician(s2) : new Statistician(s1);
        else if(s1.getLength() == 0 || s2.getLength() == 0) return s1.getLength() == 0 ? new Statistician(s2) : new Statistician(s1);
        else {
            Statistician s3 = new Statistician();
            s3.LastNumber = s2.getLastNumber();
            s3.LargestNum = Math.max(s1.getLargestNum(),s2.getLargestNum());
            s3.SmallestNum = Math.min(s1.getSmallestNum(),s2.getSmallestNum());
            s3.Length = s1.getLength() + s2.getLength();
            s3.Sum = s1.getSum() + s2.getSum();
            s3.Mean = s3.getSum() / s3.getLength();
            return s3;
        }
    }
    @Override
    public String toString(){ // Just add more methods here to test it. (if needed)
        return "LargeNum: " + getLargestNum() +
                "\nSmallNum: " + getSmallestNum() +
                "\nLastNum: " + getLastNumber() +
                "\nMean: " + getMean() +
                "\nLength: " + getLength() +
                "\nSum: " + getSum() +
                "\n";
    }
}
