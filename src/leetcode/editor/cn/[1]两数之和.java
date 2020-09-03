//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


package leetcode.editor.cn;

class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] arr=new int[]{150,24,79,50,88,345,3};
        int[] ints = solution.twoSum(arr, 200);
        System.out.println(ints[0]+","+ints[1]);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum (int[] numbers, int target) {
            int[] nums=new int[numbers.length];
            for(int i=0;i<numbers.length;i++){
                nums[i]=numbers[i];
            }
            sort(numbers,0,numbers.length-1);
            int i=0;
            int j=numbers.length-1;
            while(i<j){
                int sum=numbers[i]+numbers[j];
                if(sum==target){
                    break;
                }else if(sum>target){
                    j--;
                }else {
                    i++;
                }
            }
            int[] ret=new int[2];
            int t=0;
            int first=numbers[i];
            int second=numbers[j];
            for(int k=0;k<numbers.length;k++){
                if(nums[k]==first||nums[k]==second){
                    ret[t++]=k+1;
                }
            }
            return ret;
        }

        public void sort(int[] arr,int start,int end){
            if(start>=end){
                return;
            }
            int start0=start;
            int end0=end;
            while(start<=end){
                while(start<=end&&arr[start]<=arr[start0]){
                    start++;
                }
                while(start<=end&&arr[end]>=arr[start0]){
                    end--;
                }
                if(start<end){
                    int temp=arr[start];
                    arr[start]=arr[end];
                    arr[end]=temp;
                }
            }
            int temp0=arr[start0];
            arr[start0]=arr[end];
            arr[end]=temp0;
            sort(arr,start0,end-1);
            sort(arr,end+1,end0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}