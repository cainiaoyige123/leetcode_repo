package others.niuke;
/* gh
 * 2020/8/8
 * 下午1:50
 */

public class LC9 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow=head;
            ListNode fast=head;
            while (true){
                if(fast!=null&&fast.next!=null){
                    fast=fast.next.next;
                }else {
                    return null;
                }
                slow=slow.next;
                if(slow==fast){//相遇
                    break;
                }
            }
            slow=head;
            while (fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return slow;
        }
    }
}
