package sort;
//归并排序链表实现
public class MergeSortLinkedList {

    public static void main(String[] args) {
        ListNode node1=new ListNode(5);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(9);
        ListNode node4=new ListNode(6);
        ListNode node5=new ListNode(1);
        ListNode node6=new ListNode(8);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        MergeSortLinkedList merge=new MergeSortLinkedList();
        merge.printList(node1);
        ListNode ret=merge.mergeSort(node1);
        merge.printList(ret);
    }

    public ListNode merge(ListNode head1,ListNode head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        ListNode ret=new ListNode(-1);
        ListNode ret1=ret;
        while (true){
            if(head1==null||head2==null){
                break;
            }
            if(head1.val>head2.val){
                ret1.next=head2;
                head2=head2.next;
            }else {
                ret1.next=head1;
                head1=head1.next;
            }
            ret1=ret1.next;
        }
        if(head1!=null){
            ret1.next=head1;
        }else {
            ret1.next=head2;
        }
        return ret.next;
    }

    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode right=getMid(head);//右边
        ListNode newleft=mergeSort(head);
        ListNode newRight=mergeSort(right);
        return merge(newleft,newRight);
    }

    public ListNode getMid(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (true){
            if(fast==null||fast.next==null){
                break;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode ret=slow.next;
        slow.next=null;
        return ret;
    }

    public void printList(ListNode node){
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }


}
