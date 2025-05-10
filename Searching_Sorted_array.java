import java.util.*;

public class Searching_Sorted_array {
    static int count1=0,count2=0;
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        linear_search(new int[]{3,3,3,4,5},3);
        binary_search(new int[]{7,7,7,7,7},7);
    }

    public static void linear_search(int arr[],int target)
    {
        int count=0;
        int ans=-1;
        for(int i=0;i<arr.length;i++)
        {
            count++;
            if(arr[i]==target)
            {
                ans=i;
                break;
            }
        }
        System.out.println("Linear search index :"+ans);
        System.out.println("Linear search count :"+count);
    }

    public static void binary_search(int arr[],int target) 
    {
        
        int left = 0, right = arr.length - 1;
        int count=0,ans=-1;
        while (left <= right) 
        {   
            count++;
            int mid = left + (right - left) / 2; 
               
            if (arr[mid] == target)
            {
                if(mid!=0 && arr[mid-1]==target)
                {
                    right=mid-1;
                }
                else
                {
                    ans=mid;
                    break ;
                }
            } 
            else if (arr[mid] > target) 
            {
                right = mid - 1; 
            } 
            else 
            {
                left = mid + 1; 
            }
        }
        System.out.println("Binary search index :"+ans);
        System.out.println("Binary search count :"+count);
    }   
}