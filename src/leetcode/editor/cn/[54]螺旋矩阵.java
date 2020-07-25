//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ret = new ArrayList<>();
            if(matrix.length==0){
                return ret;
            }
            int lenX = matrix.length;
            int lenY = matrix[0].length;
            int leftX = 0;
            int leftY = 0;
            while (true) {
                if (lenX < 1 || lenY < 1) {
                    break;
                }
                printLevel(matrix, leftX, leftY, lenX, lenY, ret);
                lenX -= 2;
                lenY -= 2;
                leftX++;
                leftY++;
            }
            return ret;
        }

        /**
         * @param matrix 矩阵
         * @param leftX  左上角第一个元素的X坐标
         * @param leftY  左上角第一个元素的Y坐标
         * @param lenX   该层的X长度
         * @param lenY   该层的Y长度
         */
        public void printLevel(int[][] matrix, int leftX, int leftY, int lenX, int lenY, List<Integer> list) {
            for (int i = 0; i < lenY; i++) {
                list.add(matrix[leftX][leftY + i]);
            }
            if(lenX==1){
                return;
            }
            for (int i = 1; i < lenX; i++) {
                list.add(matrix[leftX + i][leftY + lenY - 1]);
            }
            if(lenY==1){
                return;
            }
            for (int i = lenY - 2; i >= 0; i--) {
                list.add(matrix[leftX + lenX - 1][leftY + i]);
            }
            for (int i = lenX - 2; i >= 1; i--) {
                list.add(matrix[leftX + i][leftY]);
            }
        }
    }
}