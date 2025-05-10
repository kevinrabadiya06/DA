import java.util.*;

class lcs_unit{
    int num;
    lcs_unit parent;
    boolean flag;
    Character character;

    lcs_unit()
    {
        num=0;
        parent=null;
        flag=false;
        character=null;
    }
}

public class Longets_Common_Subsequence {

    static int length;
    static String LCS;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String a=sc.next();
        String b=sc.next();

        get_lcs(a, b);

        System.out.println();
        System.out.println("Longest common Subsequence="+LCS);
        System.out.println("Length="+length);

        sc.close();
    }

    //LCS FOR JUST LENGTH
    public static int lcs(String a,String b)
    {
        int m=a.length(),n=b.length();
        int dp[][]=new int[m+1][n+1];

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    //LCS FOR ENTIRE STRING
    public static void get_lcs(String a,String b)
    {
        int m=a.length(),n=b.length();

        lcs_unit matrix[][]=new lcs_unit[m+1][n+1];
    

        for(int i=1;i<=m;i++)
        {
            

            for(int j=1;j<=n;j++)
            {
                matrix[i][j]=new lcs_unit();

                if(matrix[i][j-1]==null)
                {
                    matrix[i][j-1]=new lcs_unit();
                }
                if(matrix[i-1][j]==null)
                {
                    matrix[i-1][j]=new lcs_unit();
                }
                if(matrix[i-1][j-1]==null)
                {
                    matrix[i-1][j-1]=new lcs_unit();
                }


                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    matrix[i][j].flag=true;
                    matrix[i][j].parent=matrix[i-1][j-1];
                    matrix[i][j].num=matrix[i-1][j-1].num+1;
                    matrix[i][j].character=a.charAt(i-1);
                }
                else
                {
                    if(matrix[i][j-1].num>=matrix[i-1][j].num)
                    {
                        matrix[i][j].num=matrix[i][j-1].num;
                        matrix[i][j].parent=matrix[i][j-1];
                    }
                    else
                    {
                        matrix[i][j].num=matrix[i-1][j].num;
                        matrix[i][j].parent=matrix[i][j-1];
                    }
                }
            }
        }

        lcs_unit temp=matrix[m][n];
        length=matrix[m][n].num;
        LCS="";

        while(temp!=null)
        {
            if(temp.flag)
            {
                LCS=temp.character+LCS;
            }
            temp=temp.parent;
        }
    }
}
