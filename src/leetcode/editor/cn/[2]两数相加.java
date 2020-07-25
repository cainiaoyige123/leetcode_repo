//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


package leetcode.editor.cn;

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = l1.val + l2.val;
            int yu = sum % 10;
            int jin = sum / 10;
            ListNode head = new ListNode(yu);
            ListNode p = head;
            while (true) {
                l1 = l1.next;
                l2 = l2.next;
                if (l1 == null) {
                    if (l2 == null) {
                        if (jin == 1) {
                            p.next = new ListNode(1);
                        }
                        return head;
                    } else {
                        if (jin == 1) {
                            l2.val++;
                        }
                        if(l2.val>=10){
                            pum(l2);
                        }
                        p.next = l2;
                        return head;
                    }
                } else {
                    if (l2 == null) {
                        if (jin == 1) {
                            l1.val++;
                        }
                        if(l1.val>=10){
                            pum(l1);
                        }
                        p.next = l1;
                        return head;
                    } else {
                        sum = l1.val + l2.val + jin;
                        jin = sum / 10;
                        yu = sum % 10;
                        p.next = new ListNode(yu);
                        p = p.next;
                    }
                }
            }
        }

        public void pum(ListNode l){
            if(l.val<10){
                return ;
            }
            int num=l.val;
            int yu=num%10;
            int jin=num/10;
            l.val=yu;
            if(l.next==null){
                if(jin==1){
                    l.next=new ListNode(1);
                }else {
                    return;
                }
            }else {
                l.next.val+=jin;
            }
            pum(l.next);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}