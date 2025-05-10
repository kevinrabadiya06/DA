class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length==0)
        return 0;
        int a=nums.length*(nums.length+1)/2;

        for(int i=0;i<nums.length;i++)
        {
            a-=nums[i];
        }
        return a;
    }
}

public class Missing_Number {
    
}
