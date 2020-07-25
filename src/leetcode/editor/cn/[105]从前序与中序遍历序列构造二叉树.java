//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


package leetcode.editor.cn;

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return genTree(preorder, inorder, 0, 0, preorder.length);
        }

        /**
         * @param preorder 前序遍历全数组
         * @param inorder  　中序遍历全数组
         * @param preStart 　前序开头
         * @param inStart  　中序开头
         * @param length   　该树长度
         * @return 返回由该前需后续生成树的跟节点
         */
        public TreeNode genTree(int[] preorder, int[] inorder, int preStart, int inStart, int length) {
            if (length == 0) {
                return null;
            } else if (length == 1) {
                return new TreeNode(preorder[preStart]);
            }
            int rootVal = preorder[preStart];
            int midIndex = 0;//中序遍历跟所在索引
            for (int i = 0; i < length; i++) {
                if (inorder[inStart + i] == rootVal) {
                    midIndex = inStart + i;
                    break;
                }
            }
            int lenLeft = midIndex - inStart;
            int lenRight = length - lenLeft - 1;
            TreeNode root = new TreeNode(rootVal);
            TreeNode left = genTree(preorder, inorder, preStart + 1, inStart, lenLeft);
            TreeNode right = genTree(preorder, inorder, preStart + lenLeft + 1, inStart + lenLeft + 1, lenRight);
            root.left = left;
            root.right = right;
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}