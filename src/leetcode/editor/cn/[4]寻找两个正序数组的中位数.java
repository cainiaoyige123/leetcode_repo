//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] arr1={1};
        int[] arr2={2,3,4,5};
        double ret = solution.findMedianSortedArrays(arr1, arr2);
        System.out.println(ret);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        double ret = 0;
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            boolean one = true;
            if ((len1 + len2) % 2 == 0) {
                one = false;
            }
            int k = (len1 + len2 + 1) / 2;

            findMedianSortedArrays0(nums1, nums2, 0, 0, k, one);
            return ret;
        }

        /**
         * @param A
         * @param B
         * @param beginA A数组的本次开始索引
         * @param beginB B数组的本次开始索引
         * @param k      寻找第k小的数字
         * @param one    标识是否是返回第k小(true),还是第k和k+1小的平均值(false)
         */
        public void findMedianSortedArrays0(int[] A, int[] B, int beginA, int beginB, int k, boolean one) {
            if (one) {
                if (k == 1) {
                    if (beginA < A.length && beginB < B.length) {
                        ret = Math.min(A[beginA], B[beginB]);
                        return;
                    }
                    if (beginA < A.length) {
                        ret = A[beginA];
                        return;
                    }
                    if (beginB < B.length) {
                        ret = B[beginB];
                    }
                } else {
                    int k1 = k / 2;
                    int nextA = Math.min(beginA + k1 - 1, A.length - 1);//A的索引
                    int num1;
                    if(nextA<beginA){
                        num1=Integer.MAX_VALUE;
                    }else {
                        num1=A[nextA];
                    }
                    int nextB = Math.min(beginB + k1 - 1, B.length - 1);
                    int num2;
                    if(nextB<beginB){
                        num2=Integer.MAX_VALUE;
                    }else {
                        num2=B[nextB];
                    }
                    if (num1 < num2) {
                        int k2 = nextA - beginA + 1;
                        findMedianSortedArrays0(A, B, nextA + 1, beginB, k-k2, one);
                    } else {
                        int k2 = nextB - beginB + 1;
                        findMedianSortedArrays0(A, B, beginA, nextB + 1, k-k2, one);
                    }
                }
            } else {
                if (k == 1) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = beginA; i < A.length && i < beginA + 2; i++) {
                        list.add(A[i]);
                    }
                    for (int i = beginB; i < B.length && i < beginB + 2; i++) {
                        list.add(B[i]);
                    }
                    Collections.sort(list);
                    ret=(list.get(0)+list.get(1))/2.0;
                } else {
                    int k1 = k / 2;
                    int nextA = Math.min(beginA + k1 - 1, A.length - 1);//A的索引
                    int num1;
                    if(nextA<beginA){
                        num1=Integer.MAX_VALUE;
                    }else {
                        num1=A[nextA];
                    }
                    int nextB = Math.min(beginB + k1 - 1, B.length - 1);
                    int num2;
                    if(nextB<beginB){
                        num2=Integer.MAX_VALUE;
                    }else {
                        num2=B[nextB];
                    }
                    if (num1 < num2) {
                        int k2 = nextA - beginA + 1;
                        findMedianSortedArrays0(A, B, nextA + 1, beginB, k-k2, one);
                    } else {
                        int k2 = nextB - beginB + 1;
                        findMedianSortedArrays0(A, B, beginA, nextB + 1, k-k2, one);
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}