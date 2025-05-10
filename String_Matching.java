
public class String_Matching {

    public static void main(String[] args) {
        String text="abcdefg" , pattern="def" ;
        boolean flag=false;

        for(int i=0;i<text.length();i++)
        {
            int org=i;
            for(int j=0;j<pattern.length();j++)
            {
                if(text.charAt(i)==pattern.charAt(j))
                {
                    i++;
                    flag=true;
                }
                else
                {
                    flag=false;
                    break;
                }
            }

            if(!flag)
            i=org;

        }

        System.out.println(flag ? "Pattern Found" : "Pattern not found");
    }
    
}