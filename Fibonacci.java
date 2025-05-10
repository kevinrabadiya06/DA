public class Fibonacci {
    static int count1=0,count2=-1;

    public static void fibo2(long limit,long a,long b)
    {
        count2++;
        if(a>limit)
        return;
        
        System.out.print(a+" ");
        fibo2(limit, b, a+b);
    }

    public static void fibo1(long num)
    {
        long first=0;
        long second=1;
        long fibo=0;

        while(first<num)
        {
            count1++;
            System.out.print(first+" ");
            fibo=first+second;
            first=second;
            second=fibo;
        }
    }
    public static void main(String[] args) {
        // fibo1(10);
        // System.out.println(" , Count="+count1);
        // fibo2(10,0, 1);
        // System.out.println(" , Count="+count2);

        for(int i=0;i<args.length;i++)
        {
            count1=0;
            fibo1(Long.parseLong(args[i]));
            System.out.println("  count="+count1);
        }
    }
}