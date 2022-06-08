package src;

//https://leetcode.com/problems/binary-search/
public class Binary_Search {
    public int search(int[] nums, int target) {
        int head=0; int tail = nums.length-1;
        while(head <= tail){
            int midIndex = (head + tail) / 2;
            if( nums[midIndex] == target ) return midIndex;
            else if( nums[midIndex] < target) head = midIndex+1;
            else //if( nums[midIndex] > target)
                tail = midIndex-1;
        }
        return -1;
    }
}
