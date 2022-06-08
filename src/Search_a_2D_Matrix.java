package src;

//https://leetcode.com/problems/search-a-2d-matrix/
public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int head = 0;
        int tail = matrix.length-1;
        while(head <= tail){
            int m = (head + tail)/2;
            if(target >= matrix[m][0] && target <= matrix[m][matrix[m].length-1]){
                return search(matrix[m], target);
            }
            else if(target < matrix[m][0])
                tail = m -1;
            else // target > matrix[m][matrix.length-1]
                head = m + 1;
        }
        return false;
    }

    // [2, 7, 11, 15] target = 11
    // (0, 1, 2,  3 )
    public boolean search(int[] array, int target){
        int head = 0;
        int tail = array.length-1;
        while(head<=tail) {
            int m = (head + tail) / 2;
            if (array[m] == target) return true;
            else if (target < array[m]) tail = m - 1;
            else // target > array[m]
                head = m + 1;
        }
        return false;
    }
}
