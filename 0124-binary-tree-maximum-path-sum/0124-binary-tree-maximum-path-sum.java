class Solution {
    private int maxSum; // global variable to store the maximum path sum

    // Helper function to recursively calculate the maximum path sum starting from the current node
    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate maximum path sum for the left and right subtrees
        int leftSum = Math.max(0, maxPathSumHelper(root.left)); // max path sum starting from left child
        int rightSum = Math.max(0, maxPathSumHelper(root.right)); // max path sum starting from right child

        // Update the global maxSum by considering the path through the current node
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

        // Return the maximum path sum starting from the current node (either left or right subtree + current node value)
        return Math.max(leftSum, rightSum) + root.val;
    }

    // Main function to find the maximum path sum in the binary tree
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer
        maxPathSumHelper(root); // Call helper function to recursively calculate maximum path sum
        return maxSum;
    }
}