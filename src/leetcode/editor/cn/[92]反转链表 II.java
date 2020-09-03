//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表


package leetcode.editor.cn;

class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            int i=1;
            ListNode head0=new ListNode(-1);
            head0.next=head;
            ListNode head1;
            ListNode temp=head;
            while (true){
                if(i==m-1){
                    head0=temp;
                }
                if(i==n){
                    head1=temp.next;
                    temp.next=null;
                    break;
                }
                temp=temp.next;
                i++;
            }
            ListNode[] reverse = reverse(head0.next);
            reverse[1].next=head1;
            if(head==reverse[1]){
                return reverse[0];
            }else {
                head0.next=reverse[0];
                return head;
            }
        }

        /**
         *
         * @param head 待反转的链表
         * @return 返回反转后的链表头节点和尾节点
         */
        public ListNode[] reverse(ListNode head){
            ListNode pre=new ListNode(-1);
            ListNode temp=head;
            ListNode next;
            while (temp!=null){
                next=temp.next;
                temp.next=pre;
                pre=temp;
                temp=next;
            }
            return new ListNode[]{pre,head};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}