//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(5);
        root.left=node1;
        root.right=node2;
        node1.left=new TreeNode(3);
        node1.right=new TreeNode(4);
        node2.right=new TreeNode(6);
        solution.flatten(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public void flatten(TreeNode root) {
            if(root==null){
                return;
            }
            Queue<TreeNode> queue=getPreOrderNodes(root);
            TreeNode head=queue.poll();
            TreeNode p=head;
            while (!queue.isEmpty()){
                p.right=queue.poll();
                p=p.right;
            }
            root=head;
        }

        public Queue<TreeNode> getPreOrderNodes(TreeNode root){
            Queue<TreeNode> ret=new LinkedList<>();
            Stack<TreeNode> stack=new Stack<>();
            stack.push(root);
            ret.offer(root);
            while (!stack.isEmpty()){
                TreeNode node=stack.peek();
//                ret.offer(node);//第一次在这个地方加入queue，会重复加入
                if(node.left!=null){
                    stack.push(node.left);
                    ret.offer(node.left);//需要在push的时候加入queue，因为只会push一次
                    node.left=null;
                    continue;
                }
                if(node.right!=null){
                    stack.push(node.right);
                    ret.offer(node.right);
                    node.right=null;
                    continue;
                }
                stack.pop();
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}