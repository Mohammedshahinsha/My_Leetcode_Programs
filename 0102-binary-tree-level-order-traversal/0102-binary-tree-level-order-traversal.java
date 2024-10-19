
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){return list;}
        solve(root,0);
        return list;
    }
    public void solve(TreeNode root, int count){
        if(count == list.size()){
            List<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            list.add(new ArrayList<>(arr));
        }else{
            List<Integer> arr = list.get(count);
            arr.add(root.val);
            list.set(count, new ArrayList<>(arr));
        }
        if(root.left==null && root.right==null){
            return;
        }
        if(root.left!=null){
            solve(root.left, count+1);
        }
        if(root.right!=null){
            solve(root.right, count+1);
        }
        return;
    }
}