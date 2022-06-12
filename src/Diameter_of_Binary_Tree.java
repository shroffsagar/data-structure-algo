package src;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class Diameter_of_Binary_Tree {
    int maxDiam = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfNode(root);
        return maxDiam;
    }

    public int heightOfNode(TreeNode node){
        if(node == null) return -1;
        int leftHt = heightOfNode(node.left);
        int rightHt = heightOfNode(node.right);
        maxDiam = Math.max(leftHt+rightHt+2, maxDiam);
        return 1+Math.max(leftHt, rightHt);
    }
}
