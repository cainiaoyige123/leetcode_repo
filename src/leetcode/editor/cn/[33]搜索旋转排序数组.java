//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


package leetcode.editor.cn;

class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums={1,3,5};
        int ret=solution.search(nums,2);
        System.out.println(ret);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length==0){
                return -1;
            }else if(nums.length==1){
                if(nums[0]==target){
                    return 0;
                }else {
                    return -1;
                }
            }
            int start = 0;
            int end = nums.length - 1;
            int minIndex = 0;
            while (nums[start]>=nums[end]) {
                if(end-start==1){
                    minIndex=end;
                    break;
                }
                int mid = (start + end) / 2;
                if (nums[mid] >= nums[start]) {
                    start = mid;
                    continue;
                }
                if (nums[mid] <= nums[end]) {
                    end = mid;
                    continue;
                }
                if (nums[start] == nums[end] && nums[mid] == nums[start]) {
                    minIndex = search0(nums, start, end);
                    break;
                }
            }


            start = 0;
            end = nums.length - 1;
            if(minIndex==0){
                return binSearc(nums,start,end,target);
            }
            if (target>=nums[start]&&target<=nums[minIndex-1]){//处于前半
                return binSearc(nums,start,minIndex-1,target);
            }else if(target>=nums[minIndex]&&target<=nums[end]){//后半
                return binSearc(nums,minIndex,end,target);
            }else {
                return -1;
            }
        }

        public int search0(int[] nums, int start, int end) {
            int result = nums[start];
            int minIndex = start;
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] < result) {
                    result = nums[i];
                    minIndex = i;
                }
            }
            return minIndex;
        }

        public int binSearc(int[] nums,int start,int end,int target){//二分查找写法
            while (start<=end){//此处必须为<=
                int mid=(start+end)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]>target){
                    end=mid-1;//必须为mid-1,不能为mid
                }else {
                    start=mid+1;
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}