import java.util.*;

class units implements Comparable<units>{
    double profit;
    double duration;
    double ratio;

    units(double profit,double duration)
    {
        this.duration=duration;
        this.profit=profit;
        this.ratio=profit/duration;
    }

    @Override
    public int compareTo(units other) {
        return Double.compare(other.ratio, this.ratio); 
    }
}

class Solution{
    private double total_duration;
    private units knapsack[];
    private double max_profit;

    Solution(double total_duration,double[] profit, double[] duration)
    {
        this.total_duration=total_duration;
        this.max_profit=0;

        if(profit.length!=duration.length)
        throw new IllegalArgumentException("The length of profit and duration should be same");

        knapsack=new units[profit.length];

        for(int i=0;i<profit.length;i++) // n
        {
            knapsack[i]=new units(profit[i], duration[i]);
        }

        Arrays.sort(knapsack); // nlog(n)

        for(units u : knapsack) // n
        {
            if(u.duration>total_duration)
            {
                max_profit+=(total_duration*u.profit)/u.duration;
                break;
            }

            max_profit+=u.profit;
            total_duration-=u.duration;
        }
    }

    public double get_maximum_profit()
    {
        return max_profit;
    }

}

public class Fractional_Knapsack {

    public static void main(String[] args) {
        Solution s=new Solution(10,new double[]{70,78,40,90,30,110,100}, new double[]{3,4,2,5,2,7,6});
        System.out.println(s.get_maximum_profit());
    }
}