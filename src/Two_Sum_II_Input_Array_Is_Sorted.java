package src;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class Two_Sum_II_Input_Array_Is_Sorted {
    //using 2-pointer
    public int[] twoSum(int[] arr, int target) {
        int tail = arr.length-1;
        for(int head=0; head<tail;){
            if(arr[head]+arr[tail] == target){
                return new int[] {head+1, tail+1};
            }
            else if(arr[head]+arr[tail] > target) {
                tail --;
            }
            else { //arr[head]+arr[tail] < target
                head ++;
            }
        }
        return null;
    }

    //using constant array
    public int[] twoSum2(int[] numbers, int target) {
        Integer [] complimentIndexes = new Integer[2002];
        for(int i=0; i<numbers.length; i++){
            int compliment=target-numbers[i];
            Integer complimentIndex = complimentIndexes[1000 + compliment];
            if(complimentIndex != null){
                return new int[]{complimentIndex+1, i+1};
            }
            else {
                complimentIndexes[1000 + numbers[i]] = i;
            }
        }
        return null;
    }

    //using hashmap + variable memory
    public int[] twoSum3(int[] numbers, int target) {
        Map<Integer, Integer> complimentIndexes = new HashMap<>();
        int i = 0;
        for(int num : numbers){
            int compliment = target - num;
            Integer complimentIndex = complimentIndexes.get(compliment);
            if(complimentIndex != null){
                return new int[]{complimentIndex+1, i+1};
            }
            else {
                complimentIndexes.put(num, i);
                i++;
            }
        }
        return null;
    }
}
