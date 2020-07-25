//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表


package leetcode.editor.cn;

import java.util.Stack;

class ReorderList {
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        solution.reorderList(node1);
        solution.printList(node1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if(head==null||head.next==null||head.next.next==null){
                return;
            }
            ListNode mid=getMid(head).next;
            getMid(head).next=null;
            Stack<ListNode> stack=new Stack<>();
            while (mid!=null){
                stack.push(mid);
                mid=mid.next;
            }
            ListNode p=head;
            ListNode ret=new ListNode(-1);
            while (!stack.isEmpty()){
                ret.next=p;
                p=p.next;
                ret=ret.next;
                ret.next=stack.pop();
                ret=ret.next;
            }
            ret.next=p;

        }

        public ListNode getMid(ListNode head){
            ListNode p1=head;
            ListNode p2=head;
            while (true){
                if(p2.next==null||p2.next.next==null){
                    return p1;
                }
                p2=p2.next.next;
                p1=p1.next;
            }
        }
        public void printList(ListNode head){
            while (head!=null){
                System.out.print(head.val+" ");
                head=head.next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}