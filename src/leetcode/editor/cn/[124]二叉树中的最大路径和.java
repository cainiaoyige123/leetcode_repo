//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.TreeSet;

class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum().new Solution();
        TreeNode root=new TreeNode(2);
        //        TreeNode right=new TreeNode(3);
        root.left= new TreeNode(-1);
//        root.right=right;
        int max=solution.maxPathSum(root);
        System.out.println(max);
    }


    class Solution {
        int max=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if(root==null){
                return Integer.MIN_VALUE;
            }
            if(root.left==null&&root.right==null){
                return root.val;
            }
            int leftNum=maxPathSum(root.left);
            int rightNum=maxPathSum(root.right);
            if(leftNum>max)
                max=leftNum;
            if(rightNum>max)
                max=rightNum;
            int left=0;
            int right=0;
            if(root.left!=null){
                left=root.left.val;
            }
            if(root.right!=null){
                right=root.right.val;
            }
            int ret=left+right+root.val;
            root.val=Math.max(left,right)+root.val;
            return Math.max(Math.max(ret, max),root.val);
        }


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}