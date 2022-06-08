package src;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contains-duplicate/
public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for(int num : nums){
            Integer count = hashTable.get(num);
            if(count != null && count == 1) return true;
            count = (count == null) ? 1 : count + 1;
            hashTable.put(num, count);
        }
        return false;
    }
}
