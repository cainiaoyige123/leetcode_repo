//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView{
      public static void main(String[] args) {
           Solution solution = new BinaryTreeRightSideView().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)

 //Definition for a binary tree node.
  class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        int index=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        index++;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            index--;
            if(poll.left!=null){
                queue.offer(poll.left);
            }
            if(poll.right!=null){
                queue.offer(poll.right);
            }
            if(index==0){
                ret.add(poll.val);
                index=queue.size();
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }