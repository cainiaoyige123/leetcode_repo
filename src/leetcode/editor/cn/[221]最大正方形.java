//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


package leetcode.editor.cn;

class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();
    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix.length < 1) {
                return 0;
            }
            int lenX = matrix.length;
            int lenY = matrix[0].length;
            int[][] dp = new int[lenX][lenY];
            int max = 0;
            for (int i = 0; i < lenY; i++) {
                char ch = matrix[0][i];
                if (ch == '0') {
                    dp[0][i] = 0;
                } else {
                    dp[0][i] = 1;
                    max = 1;
                }
            }
            for (int i = 1; i < lenX; i++) {
                char ch = matrix[i][0];
                if (ch == '0') {
                    dp[i][0] = 0;
                } else {
                    dp[i][0] = 1;
                    max = 1;
                }
            }
            for (int i = 1; i < lenX; i++) {
                for (int j = 1; j < lenY; j++) {
                    char ch = matrix[i][j];
                    if (ch == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        if (dp[i][j] > max) {
                            max = dp[i][j];
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return max * max;
        }
    }

}