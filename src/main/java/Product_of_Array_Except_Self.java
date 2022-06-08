import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/product-of-array-except-self/
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        Set<Integer> zeroIndices = new HashSet<Integer>();
        int indx=0;
        for(int i: nums){
            if(i!=0)
                totalProduct *= i;
            else
                zeroIndices.add(indx);
            indx ++;
        }
        int [] result = new int[nums.length];
        indx=0;
        for(int i: nums){
            if(zeroIndices.size() == 0)
                result[indx] = totalProduct/i;
            else if(zeroIndices.size() == 1 && zeroIndices.contains(indx))
                result [indx] = totalProduct;
            indx++;
        }
        return result;
    }
}
