package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/top-k-frequent-elements/
public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(int n: freq.keySet()){
            int cnt = freq.get(n);
            List<Integer> bucket = buckets[cnt];
            bucket = (bucket == null) ? new ArrayList<>() : bucket;
            bucket.add(n);
            buckets[cnt] = bucket;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=buckets.length-1; i>=0 && result.size()<k; i--){
            List<Integer> bucket = buckets[i];
            if(bucket != null){
                int m = Math.min(k-result.size(), bucket.size());
                result.addAll(bucket.subList(0, m));
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
