//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
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
        List<List<Integer>> ret=new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if(root==null){
                return new ArrayList<>();
            }
            pathSum0(root,sum,new ArrayList<>());
            return ret;
        }

        public void pathSum0(TreeNode root,int sum,List<Integer> list){
            list.add(root.val);
            sum-=root.val;
            if(root.left==null&&root.right==null){
                if(sum==0){
                    List<Integer> add=new ArrayList<>(list);
                    ret.add(add);
                }
                return;
            }
            if(root.left!=null){
                pathSum0(root.left,sum,list);
                int size=list.size();
                list.remove(size-1);
            }
            if(root.right!=null){
                pathSum0(root.right,sum,list);
                int size=list.size();
                list.remove(size-1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}