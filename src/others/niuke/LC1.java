package others.niuke;
/* gh
 * 2020/8/8
 * 下午12:38
 */

public class LC1 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public int run (TreeNode root) {
        if(root==null){
            return 0;
        }
        return run0(root);
    }

    public int run0(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return run0(root.right)+1;
        }
        if(root.right==null){
            return run0(root.left)+1;
        }
        return Math.min(run0(root.left),run0(root.right))+1;
    }
}
