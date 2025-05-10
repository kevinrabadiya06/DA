import java.util.*;

public class Two_sum {
    public static void main(String[] args) {
        int ans[]=twoSum(new int[]{2,7,11,15},9);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            return new int[]{i,map.get(target-nums[i])};

            map.put(nums[i], i);
        }
        return null;
    }
}