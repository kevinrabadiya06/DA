public class Factorial {
    static int count1=0,count2=0;
    public static void main(String[] args) {
        for(String i : args)
        {
            count1=0;
            count2=0;
            show(Long.parseLong(i));
        }
    }

    public static void show(long num)
    {
        System.out.println("Iterative :"+fact1(num));
        System.out.println("Count="+count1);
        System.out.println("Recursive :"+fact2(num));
        System.out.println("Count="+count2);
    }

    public static long fact1(long num)
    {
        long fact=1;
        for(int i=2;i<=num;i++)
        {
            count1++;
            fact*=i;
        }
        return fact;
    }

    public static long fact2(long num)
    {
        count2++;
        return (num<=1) ? 1 : num*fact2(num-1);
    }
}
