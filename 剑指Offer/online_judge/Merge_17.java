package online_judge;

/**
 * 合并两个排序的链表 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge_17 {

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

        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        ListNode node = merge(node1, node2);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode merge(ListNode list1, ListNode list2) {

        /* my method */
//        if (list1 == null && list2 == null)
//            return null;
//        else if (list1 == null)
//            return list2;
//        else if (list2 == null)
//            return list1;
//
//        ListNode nodeHead = null, nodeEnd = null, p, q;
//        p = list1;
//        q = list2;
//        while (p != null && q != null) {
//            ListNode node;
//            if (p.val <= q.val) {
//                node = p;
//                p = p.next;
//                node.next = null;
//            } else {
//                node = q;
//                q = q.next;
//                node.next = null;
//            }
//            if (nodeHead == null) {
//                nodeHead = node;
//                nodeEnd = node;
//            } else {
//                nodeEnd.next = node;
//                nodeEnd = node;
//            }
//        }
//        if (p != null)
//            nodeEnd.next = p;
//        else if (q != null)
//            nodeEnd.next = q;
//        else
//            nodeEnd.next = null;
//
//        return nodeHead;

        /* a better method */
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode pMergeHead = null;
        if (list1.val <= list2.val) {
            pMergeHead = list1;
            pMergeHead.next = merge(list1.next, list2);
        } else {
            pMergeHead = list2;
            pMergeHead.next = merge(list1, list2.next);
        }

        return pMergeHead;
    }
}
