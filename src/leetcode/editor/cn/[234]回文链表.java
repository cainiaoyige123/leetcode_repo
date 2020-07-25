//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            int len = 0;
            ListNode p = head;
            while (p != null) {
                len++;
                p = p.next;
            }
            p = head;
            int start = (len + 1) / 2;
            int i = 0;
            while (i < start) {
                p = p.next;
                i++;
            }
            ListNode start0 = reverse0(p);
            p = head;
            while (start0 != null) {
                if (start0.val != p.val) {
                    return false;
                }
                start0 = start0.next;
                p = p.next;
            }
            return true;

        }

        public ListNode reverse0(ListNode head) {
            ListNode pre = new ListNode(-1);
            ListNode temp = head;
            ListNode next = head.next;
            while (next != null) {
                temp.next = pre;
                pre = temp;
                temp = next;
                next = temp.next;
            }
            temp.next = pre;
            head.next = null;
            return temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}