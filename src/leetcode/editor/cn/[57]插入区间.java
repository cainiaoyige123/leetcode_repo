//给出一个无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出: [[1,5],[6,9]]
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出: [[1,2],[3,10],[12,16]]
//解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
// Related Topics 排序 数组


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

class InsertInterval{
      public static void main(String[] args) {
           Solution solution = new InsertInterval().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        int lenOld=intervals.length;
        int min=newInterval[0];
        int max=newInterval[1];
        int i=0;
        int newMin=-1;
        int minOldIndex=-1;
        while (i<lenOld){
            if(min<=intervals[i][0]){
                newMin=min;
                minOldIndex=i;
                break;
            }
            if(min<=intervals[i][1]){
                newMin=intervals[i][0];
                minOldIndex=i;
                break;
            }
            i++;
        }
        int j=intervals.length-1;
        int newMax=-1;
        int maxOldIndex=-1;
        while (j>=0){
            if(max>=intervals[j][1]){
                newMax=max;
                maxOldIndex=j;
                break;
            }
            if(max>=intervals[j][0]){
                newMax=intervals[j][1];
                maxOldIndex=j;
                break;
            }
            j--;
        }
        int lenNew=lenOld-maxOldIndex+minOldIndex;
        int[][] ret=new int[lenNew][2];
        int k = 0;
        for (; k < minOldIndex; k++) {
            ret[k][0]=intervals[k][0];
            ret[k][1]=intervals[k][1];
        }
        ret[k][0]=newMin;
        ret[k][1]=newMax;
        k++;
        for (int l = maxOldIndex+1; l < lenOld; l++) {
            ret[k][0]=intervals[l][0];
            ret[k++][1]=intervals[l][1];
        }
        return ret;
    }

    public int[][] insert0(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        LinkedList<int[]> list=new LinkedList<>();
        int len=intervals.length;
        if(newInterval[1]<intervals[0][0]){
            list.addFirst(newInterval);
            for (int i = 0; i < len; i++) {
                list.addLast(intervals[i]);
            }
            return list.toArray(new int[len+1][2]);
        }
        if(newInterval[0]>intervals[len-1][1]){
            for (int i = 0; i < len; i++) {
                list.addLast(intervals[i]);
            }
            list.addLast(newInterval);
            return list.toArray(new int[len+1][2]);
        }
        for (int i = 0; i < len; i++) {
            if(newInterval[0]>intervals[i][1]){
                list.addLast(intervals[i]);
            }else if(newInterval[0]>=intervals[i][0]){

            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }