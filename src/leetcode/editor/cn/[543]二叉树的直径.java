//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树


package leetcode.editor.cn;

class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int max=0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null){
                return 0;
            }
            int ret=diameterOfBinaryTree0(root);
            return Math.max(max,ret);
        }

        public int diameterOfBinaryTree0(TreeNode root){//返回的是最大路径,跟元素的值是子树的深度
            if(root.left==null && root.right==null){
                root.val=1;
                return 0;
            }
            int maxLeft=0;
            int maxRight=0;
            int valLeft=0;
            int valRight=0;
            if(root.left!=null){
                maxLeft=diameterOfBinaryTree0(root.left);//左子树的最大路径
                valLeft=root.left.val;
            }
            if(root.right!=null){
                maxRight=diameterOfBinaryTree0(root.right);//右子树的最大路径
                valRight=root.right.val;
            }
            root.val=Math.max(valLeft,valRight)+1;
            max=Math.max(Math.max(max,maxLeft),maxRight);
            return valLeft+valRight;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}