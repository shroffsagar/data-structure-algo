package src;

//https://leetcode.com/problems/balanced-binary-tree/
public class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        return getHeightAndBalanced(root)[1] == 1;
    }

    public int[] getHeightAndBalanced(TreeNode node){
        if(node == null) return new int[]{-1, 1};

        int [] left = getHeightAndBalanced(node.left);
        int [] right = getHeightAndBalanced(node.right);

        int leftHt = left[0];
        int rightHt = right[0];

        boolean isLeftBalanced = left[1] == 1;
        boolean isRightBalanced = right[1] == 1;

        int htOfCurrNode = Math.max(leftHt, rightHt) + 1;

        if(!isLeftBalanced || !isRightBalanced) return new int[]{htOfCurrNode, 0};

        int isCurrentNodeBalanced = Math.abs(leftHt-rightHt)<=1 ? 1: 0;
        return new int[]{htOfCurrNode, isCurrentNodeBalanced};
    }
}
