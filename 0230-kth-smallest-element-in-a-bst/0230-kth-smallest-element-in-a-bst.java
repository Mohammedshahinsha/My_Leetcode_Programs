/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // 

 // Using inorder taversal, the property of inorder is it will traverse in a way which will be in asc order of elements
 // so travel k times from extreme left with inroder traversal to get the kth smallest
class Solution {
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        int[] ans= new int[1];
        inOrder(root, k, ans );
        return ans[0];
    }

   public void inOrder(TreeNode root, int k, int[] ans){
       if(root==null){
           return;
       }
       inOrder(root.left,k, ans);
       count++;
       if(k==count){
           ans[0]=root.val;
           return;
        }
       inOrder(root.right,k, ans);
   }
}