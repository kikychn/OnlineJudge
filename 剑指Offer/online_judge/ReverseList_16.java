package online_judge;
/**
 * 反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList_16 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = node1;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();

        node = reverseList(node1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        
        if(head == null) return null;
        
        ListNode pReverseHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while(pNode != null) {
            ListNode pNext = pNode.next;
            
            if(pNext == null) pReverseHead = pNode;
            
            pNode.next = pPrev;
            
            pPrev = pNode;
            pNode = pNext;
        }
        
        return pReverseHead;
    }

}
