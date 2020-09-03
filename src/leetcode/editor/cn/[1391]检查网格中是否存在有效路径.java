//给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是： 
//
// 
// 1 表示连接左单元格和右单元格的街道。 
// 2 表示连接上单元格和下单元格的街道。 
// 3 表示连接左单元格和下单元格的街道。 
// 4 表示连接右单元格和下单元格的街道。 
// 5 表示连接左单元格和上单元格的街道。 
// 6 表示连接右单元格和上单元格的街道。 
// 
//
// 
//
// 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径
//。该路径必须只沿着街道走。 
//
// 注意：你 不能 变更街道。 
//
// 如果网格中存在有效的路径，则返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[2,4,3],[6,5,2]]
//输出：true
//解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,2,1],[1,2,1]]
//输出：false
//解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1,2]]
//输出：false
//解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
// 
//
// 示例 4： 
//
// 输入：grid = [[1,1,1,1,1,1,3]]
//输出：true
// 
//
// 示例 5： 
//
// 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// 1 <= grid[i][j] <= 6 
// 
// Related Topics 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.Stack;

class CheckIfThereIsAValidPathInAGrid {
    public static void main(String[] args) {
        Solution solution = new CheckIfThereIsAValidPathInAGrid().new Solution();
        int[][] arr=new int[][]{
                {1,2},
                {2,1}
        };
        boolean ret=solution.hasValidPath(arr);
        System.out.println(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean isOk = false;
        public boolean hasValidPath(int[][] grid) {
            hasValidPath0(grid,new Stack<>(),0,0);
            return isOk;
        }


        /**
         * @param grid
         * @param eles
         * @param x    　本次的坐标
         * @param y
         */
        public void hasValidPath0(int[][] grid, Stack<Integer> eles, int x, int y) {
            if (isOk||x == grid.length - 1 && y == grid[0].length - 1) {
                isOk = true;
                return;
            }
            int num = grid[x][y];
            if (num != 0) {
                eles.push(num);
                grid[x][y] = 0;
                switch (num) {
                    case 1:
                        if (Valid(grid, x, y + 1)) {//右
                            right(grid, eles, x, y + 1);
                        }
                        if (Valid(grid, x, y - 1)) {//左
                            left(grid, eles, x, y - 1);
                        }
                        break;
                    case 2:
                        if (Valid(grid, x - 1, y)) {//上
                            up(grid, eles, x - 1, y);
                        }
                        if (Valid(grid, x + 1, y)) {//下
                            down(grid, eles, x + 1, y);
                        }
                        break;
                    case 3:
                        if (Valid(grid, x + 1, y)) {//下
                            down(grid, eles, x + 1, y);
                        }
                        if (Valid(grid, x, y - 1)) {//左
                            left(grid, eles, x, y - 1);
                        }
                        break;
                    case 4:
                        if (Valid(grid, x, y + 1)) {//右
                            right(grid, eles, x, y + 1);
                        }
                        if (Valid(grid, x + 1, y)) {//下
                            down(grid, eles, x + 1, y);
                        }
                        break;
                    case 5:
                        if (Valid(grid, x - 1, y)) {//上
                            up(grid, eles, x - 1, y);
                        }
                        if (Valid(grid, x, y - 1)) {//左
                            left(grid, eles, x, y - 1);
                        }
                        break;
                    case 6:
                        if (Valid(grid, x - 1, y)) {//上
                            up(grid, eles, x - 1, y);
                        }
                        if (Valid(grid, x, y + 1)) {//右
                            right(grid, eles, x, y + 1);
                        }
                }
                grid[x][y] = eles.pop();
            }
        }

        public boolean Valid(int[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                return false;
            }
            return true;
        }

        public void up(int[][] grid, Stack<Integer> eles, int x, int y) {
            if (grid[x][y] == 2 || grid[x][y] == 3 || grid[x][y] == 4) {
                hasValidPath0(grid, eles, x, y);
            }
        }

        public void right(int[][] grid, Stack<Integer> eles, int x, int y) {
            if (grid[x][y] == 3 || grid[x][y] == 5 || grid[x][y] == 1) {
                hasValidPath0(grid, eles, x, y);
            }
        }

        public void down(int[][] grid, Stack<Integer> eles, int x, int y) {
            if (grid[x][y] == 2 || grid[x][y] == 5 || grid[x][y] == 6) {
                hasValidPath0(grid, eles, x, y);
            }
        }

        public void left(int[][] grid, Stack<Integer> eles, int x, int y ) {
            if (grid[x][y] == 4 || grid[x][y] == 6 || grid[x][y] == 1) {
                hasValidPath0(grid, eles, x, y);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}