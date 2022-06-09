package src;

//https://leetcode.com/problems/container-with-most-water/
public class Container_With_Most_Water {
    public int maxArea(int[] heights) {
        int head = 0, tail = heights.length-1;
        int maxArea = 0;
        while(head < tail){
            int width = tail - head;
            int height = Math.min(heights[head], heights[tail]);
            int area = height * width;
            maxArea = (area > maxArea) ? area : maxArea;
            if(heights[head] <= heights[tail]){
                head ++;
            }
            else {
                tail --;
            }
        }
        return maxArea;
    }
}
