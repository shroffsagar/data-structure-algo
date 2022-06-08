import java.util.*;

//https://leetcode.com/problems/two-sum/
public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complimentIndex = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            int b = target - a;
            Integer j = complimentIndex.get(b);
            if(j != null)
                return new int [] {i,j};
            else
                complimentIndex.put(a, i);
        }
        return null;
    }
}
