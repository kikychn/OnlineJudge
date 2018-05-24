package online_judge;
/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class t15_FindKthToTail {

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

        ListNode result = findKthToTail(node1, 3);
        System.out.println(result.val);
    }

    public static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;

        /* method1 */
//        ListNode pNode = head;
//        int len = 0;
//        while (pNode != null) {
//            ++len;
//            pNode = pNode.next;
//        }
//        if (len < k)
//            return null;
//
//        pNode = head;
//        for (int i = 1; i < len - k + 1; ++i) {
//            pNode = pNode.next;
//        }
//        return pNode;

        /* method2 */
        ListNode pAhead = head;
        ListNode pBehind = null;

        for (int i = 0; i < k - 1; ++i) {
            if (pAhead.next != null)
                pAhead = pAhead.next;
            else
                return null;
        }

        pBehind = head;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }

        return pBehind;
    }

}
