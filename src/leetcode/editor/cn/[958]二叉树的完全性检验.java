//给定一个二叉树，确定它是否是一个完全二叉树。 
//
// 百度百科中对完全二叉树的定义如下： 
//
// 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：
//第 h 层可能包含 1~ 2h 个节点。） 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
// 
//
// 示例 2： 
//
// 
//
// 输入：[1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的结点没有尽可能靠向左侧。
// 
//
// 
//
// 提示： 
//
// 
// 树中将会有 1 到 100 个结点。 
// 
// Related Topics 树


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new CheckCompletenessOfABinaryTree().new Solution();
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        root.left=node1;
        root.right=node2;
        node1.left=new TreeNode(4);
        node1.right=new TreeNode(5);
        node2.right=new TreeNode(7);
        boolean is=solution.isCompleteTree(root);
        System.out.println(is);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            if(root==null){
                return true;
            }
            Queue<TreeNode> nodes=new LinkedList<>();
            Queue<Integer> nums=new LinkedList<>();
            root.val=1;
            nodes.offer(root);
            while (!nodes.isEmpty()){
                TreeNode node=nodes.poll();
                nums.offer(node.val);
                if(node.left!=null){
                    node.left.val=node.val*2;
                    nodes.offer(node.left);
                }
                if(node.right!=null){
                    node.right.val=node.val*2+1;
                    nodes.offer(node.right);
                }
            }
            int size=nums.size();
            for (int i = 0; i < size; i++) {
                if(i+1!=nums.poll()){
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}