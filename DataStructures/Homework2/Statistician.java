package DataStructures;

public class Statistician {
    private int Length = 0;
    private double LastNumber, Mean, Sum = 0, SmallestNum = Double.MAX_VALUE, LargestNum = Double.MIN_VALUE;

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

    @Override
    public String toString() { // Just add more methods here to test it. (if needed)
        return "LargeNum: " + getLargestNum() + "\nSmallNum: " + getSmallestNum() + "\nLastNum: " + getLastNumber()
                + "\nMean: " + getMean() + "\nLength: " + getLength() + "\nSum: " + getSum();
    }
}