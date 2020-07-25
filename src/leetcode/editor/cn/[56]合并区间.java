//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length<=1){
                return intervals;
            }
            List<int[]> list=new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                list.add(intervals[i]);
            }
            Collections.sort(list, (ints, t1) -> {
                if(ints[0]>t1[0]){
                    return 1;
                }else if(ints[0]<t1[0]){
                    return -1;
                }else {
                    return 0;
                }
            });
            List<int[]> ret=new ArrayList<>();
            ret.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                int start=list.get(i)[0];
                int end=ret.get(ret.size()-1)[1];
                if(start>end){
                    ret.add(list.get(i));
                }else {
                    int end1=list.get(i)[1];
                    if(end1>end){
                        ret.get(ret.size()-1)[1]=end1;
                    }
                }
            }
            int[][] rets=new int[ret.size()][];
            for (int i = 0; i < ret.size(); i++) {
                rets[i]=ret.get(i);
            }
            return rets;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}