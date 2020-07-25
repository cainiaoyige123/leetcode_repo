//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索

//误区：一个树，当左右子树都为平衡树，这棵树可不一定为平衡树
//判定：左右子树深度之差小于1,且左右子树也为平衡树

package leetcode.editor.cn;

class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(4);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node3.left=node5;
        node3.right=node6;
        boolean isBin=solution.isBalanced(root);
        System.out.println(isBin);
    }
//    leetcode submit region begin(Prohibit modification and deletion)

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            genDepth(root);
            return isBin0(root);
        }

        private boolean isBin0(TreeNode root) {
            if(root==null){
                return true;
            }
            if(root.left==null&&root.right==null){
                return true;
            }
            if(root.left==null){
                if(root.right.val>=2){
                    return false;
                }else {
                    return true;
                }
            }
            if(root.right==null){
                if(root.left.val>=2){
                    return false;
                }else {
                    return true;
                }
            }
//            if(Math.abs(root.left.val-root.right.val)>=2){
//                return false;
//            }else {
//                return isBin0(root.left)&&isBin0(root.right);
//            }
            return Math.abs(root.left.val-root.right.val)<2&&
                    isBin0(root.left)&&isBin0(root.right);
//            return isBin0(root.left)&&isBin0(root.right);//想当然
        }

        public void genDepth(TreeNode root){
            if(root==null){
                return;
            }
            if(root.left==null&&root.right==null){
                root.val=1;
                return;
            }
            if(root.left==null){
                genDepth(root.right);
                root.val=root.right.val+1;
                return;
            }
            if(root.right==null){
                genDepth(root.left);
                root.val=root.left.val+1;
                return;
            }
            genDepth(root.left);
            genDepth(root.right);
            root.val=Math.max(root.left.val,root.right.val)+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}