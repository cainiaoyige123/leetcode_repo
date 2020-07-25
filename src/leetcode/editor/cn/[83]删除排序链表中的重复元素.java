//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表


package leetcode.editor.cn;

class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head==null)
                return head;
            ListNode p=head;
            ListNode q=p.next;
            while (q!=null){
                if (p.val==q.val){
                    q=q.next;
                }else {
                    p.next=q;
                    p=p.next;
                    q=q.next;
                }
            }
            p.next=null;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}