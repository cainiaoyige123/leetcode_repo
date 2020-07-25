//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


package leetcode.editor.cn;


import java.util.*;

class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
//        char[][] ch={{'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};
        char[][] ch = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        int i = solution.numIslands(ch);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //上下左右
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public int numIslands(char[][] grid) {
            int lenx=grid.length;
            if(lenx==0)
                return 0;
            int leny=grid[0].length;
            int count=0;
            for (int i = 0; i < lenx; i++) {
                for (int j = 0; j < leny; j++) {
                    if(grid[i][j]=='1'){
                        count++;
                        dfs2(grid,i,j);
                    }
                }
            }
            return count;
        }

        public void bfs(char[][] grid, int x, int y) {//队列迭代
            int lenx = grid.length;
            int leny = grid[0].length;
            Queue<int[]> queue=new LinkedList<>();
            queue.offer(new int[]{x,y});
            while (!queue.isEmpty()){
                int[] poll = queue.poll();
                int xx=poll[0];
                int yy=poll[1];
                grid[xx][yy]='0';
                for (int i = 0; i < 4; i++) {
                    int ddx = dx[i] + xx;
                    int ddy = dy[i] + yy;
                    if (ddx >= 0 && ddx < lenx && ddy >= 0
                            && ddy < leny && grid[ddx][ddy] == '1') {
                        queue.offer(new int[]{ddx,ddy});
                    }
                }
            }
        }

        public void dfs1(char[][] grid, int x, int y) {//递归实现
            int lenx = grid.length;
            int leny = grid[0].length;
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                int ddx = dx[i] + x;
                int ddy = dy[i] + y;
                if (ddx >= 0 && ddx < lenx && ddy >= 0 && ddy < leny && grid[ddx][ddy] == '1') {
                    dfs1(grid,ddx,ddy);
                }
            }
        }

        public void dfs2(char[][] grid, int x, int y){//栈实现

        }
    }
}