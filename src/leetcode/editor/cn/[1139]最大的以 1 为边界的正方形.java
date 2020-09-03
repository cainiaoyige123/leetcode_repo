//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 动态规划


package leetcode.editor.cn;

class Largest1BorderedSquare {
    public static void main(String[] args) {
        Solution solution = new Largest1BorderedSquare().new Solution();
        int[][] arr = {
                {1, 1},
                {1, 1}
        };
        int ret = solution.largest1BorderedSquare(arr);
        System.out.println(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int len1 = grid.length;
            int len2 = grid[0].length;
            int maxLen = 0;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    //处理grid[i][j]
                    if (grid[i][j] == 1) {
                        maxLen = Math.max(maxLen, handle0(grid, i, j, 1));
                    }
                }
            }
            return maxLen * maxLen;
        }

        /**
         * @param grid
         * @param i
         * @param j
         * @param maxLen 之前的最大正方形变长
         * @return 这次处理后的最大正方形变长
         */
        public int handle0(int[][] grid, int i, int j, int maxLen) {
            int len1 = grid.length;
            int len2 = grid[0].length;
            if (i + maxLen > len1 || j + maxLen > len2) {
                return maxLen;
            }
            for (int k = 1; k < maxLen; k++) {
                if (grid[i][j + k] != 1 || grid[i + k][j] != 1) {
                    return maxLen;
                }
            }
            int k = maxLen;
            while (i + k < len1 && j + k < len2 && grid[i + k][j] == 1 && grid[i][j + k] == 1) {
                k++;
            }
            k--;
            for (int l = k; l >= maxLen; l--) {
                if (handle1(grid, i, j, l)) {
                    return l + 1;
                }
            }

            return maxLen;
        }

        public boolean handle1(int[][] grid, int i, int j, int maxLen) {
            int x1 = i + maxLen;
            int y1 = j + maxLen;
            for (int k = 1; k <= maxLen; k++) {
                if (grid[x1][j + k] != 1 || grid[i + k][y1] != 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}