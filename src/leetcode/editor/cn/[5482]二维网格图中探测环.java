//给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。 
//
// 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这
//两个格子有 相同的值 。 
//
// 同时，你也不能回到上一次移动时所在的格子。比方说，环 (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1
//, 1) 回到了上一次移动时的格子。 
//
// 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a"
//,"a"]]
//输出：true
//解释：如下图所示，有 2 个用不同颜色标出来的环：
//
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c"
//,"c"]]
//输出：true
//解释：如下图所示，只有高亮所示的一个合法环：
//
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m <= 500 
// 1 <= n <= 500 
// grid 只包含小写英文字母。 
// 
// Related Topics 深度优先搜索


package leetcode.editor.cn;

class DetectCyclesIn2dGrid {
    public static void main(String[] args) {
        Solution solution = new DetectCyclesIn2dGrid().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        思路：dfs,回溯
        递归结束条件,该节点已被访问过
        递归条件,1.不越界，2.不是pre，3.和pre元素相同
         */
        /*
        二维矩阵的深搜套路：对二维矩阵的每个节点开始深搜，所以要两层for循环
                        对之前搜过的节点是否需要保存：保存就需要判断本次深搜节点是否访问过，进行剪枝
                                                不保存就需要使用回溯法，回溯复杂度高，慎用
         */
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        public boolean containsCycle(char[][] grid) {
            int lenx = grid.length;
            int leny = grid[0].length;
            boolean[][] vis=new boolean[lenx][leny];
            for (int i = 0; i < lenx; i++) {
                for (int j = 0; j < leny; j++) {
                    if(!vis[i][j]&&containsCycle0(grid,new int[]{i,j},null,vis)){
                        return true;
                    }
                }
            }
            return false;
        }

        //递归结束条件和往下层递归的条件
        public boolean containsCycle0(char[][] grid,int[] cur,int[] pre,boolean[][] vis){
            if(vis[cur[0]][cur[1]]){
                return true;
            }
            boolean result=false;
            vis[cur[0]][cur[1]]=true;
            for (int i = 0; i < 4; i++) {
                int newX=cur[0]+dx[i];
                int newY=cur[1]+dy[i];
                if(newX>=0&&newX<grid.length&&newY>=0&&newY<grid[0].length//确保不越界
                        &&grid[newX][newY]==grid[cur[0]][cur[1]]//确保下一个点的值和本次一样
                        &&(pre==null||pre[0]!=newX||pre[1]!=newY)){//确保下一个点不是pre
                    result= containsCycle0(grid,new int[]{newX,newY},new int[]{cur[0],cur[1]},vis);
                }
                if(result){
                    break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}