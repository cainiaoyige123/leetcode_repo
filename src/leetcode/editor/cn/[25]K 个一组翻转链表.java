//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表


package leetcode.editor.cn;

class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        int[] arr=new int[]{1,2};
        ListNode pre=new ListNode(arr[0]);
        ListNode head=pre;
        for (int i = 1; i < arr.length; i++) {
            pre.next=new ListNode(arr[i]);
            pre=pre.next;
        }
        ListNode ret = solution.reverseKGroup(head, 2);
        solution.print(ret);
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            int i = 0;
            int newk = k - 1;
            ListNode temp1 = head;
            ListNode temp2 = head;
            ListNode temp3;
            ListNode tempTail = new ListNode(-1);
            ListNode p=tempTail;
            while (true) {
                if (temp1 == null || temp1.next==null) {
                    break;
                }
                temp1 = temp1.next;
                temp3 = temp1.next;
                if (i == newk - 1) {
                    ListNode[] listNodes = reverse0(temp2, temp1);
                    tempTail.next=listNodes[0];
                    tempTail=listNodes[1];
                    temp2 = temp3;
                    temp1 = temp3;
                    i=-1;
                }
                i++;
            }
            if(temp2!=null){
                tempTail.next=temp2;
            }
            return p.next;
        }

        public ListNode[] reverse0(ListNode head, ListNode tail) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode temp = head;
            ListNode next;
            while (pre != tail) {
                next = temp.next;
                temp.next = pre;
                pre = temp;
                temp = next;
            }
            head.next=null;
            return new ListNode[]{tail, head};
        }
        public void print(ListNode root){
            while (root!=null){
                System.out.print(root.val+" ");
                root=root.next;
            }
        }
    }



    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}