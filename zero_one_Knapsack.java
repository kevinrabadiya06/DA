//DP

public class zero_one_Knapsack {
    public static void main(String[] args) {
        int weights[]=new int[]{2,3,4,5};
        int values[]=new int[]{1,2,5,6};
        int capacity=8;

        System.out.println(max_profit(weights, values, capacity));

    }

    public static int max_profit(int weights[],int values[],int capacity)
    {
        int n=weights.length;

        int dp[][]=new int[n+1][capacity+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=capacity;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                    continue;
                }

                int pick=0;
                
                if(weights[i-1]<=j)
                {
                    pick=values[i-1]+dp[i-1][j-weights[i-1]];
                }

                int not_pick=dp[i-1][j];

                dp[i][j]=Math.max(pick, not_pick);
            }
        }

        return dp[n][capacity];
    }

    
}
