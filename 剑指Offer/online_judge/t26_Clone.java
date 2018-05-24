package online_judge;

/**
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class t26_Clone {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String args[]) {
        RandomListNode root = new RandomListNode('A');
        root.next = new RandomListNode('B');
        root.next.next = new RandomListNode('C');
        root.next.next.next = new RandomListNode('D');
        root.next.next.next.next = new RandomListNode('E');
        root.random = root.next.next;
        root.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next;

        RandomListNode cloneRoot = clone(root);

        RandomListNode p = cloneRoot;
        while (p != null) {
            if (p.random != null) {
                System.out.println(p.label + "-" + p.random.label);
            } else {
                System.out.println(p.label);
            }

            p = p.next;
        }
    }

    public static RandomListNode clone(RandomListNode pHead) {

        // method1,O(n^2)
//        if (pHead == null)
//            return null;
//
//        RandomListNode cloneRoot = new RandomListNode(pHead.label);
//        RandomListNode p = pHead, q = cloneRoot;
//        while (p.next != null) {
//            q.next = new RandomListNode(p.next.label);
//            p = p.next;
//            q = q.next;
//        }
//        q.next = null;
//
//        p = pHead;
//        q = cloneRoot;
//        while (p != null) {
//            if (p.random != null) {
//                RandomListNode step = pHead, stepClone = cloneRoot;
//                while (step != p.random) {
//                    step = step.next;
//                    stepClone = stepClone.next;
//                }
//                q.random = stepClone;
//            }
//            p = p.next;
//            q = q.next;
//        }

        // method2,O(n)
        if (pHead == null)
            return null;

        // 1. 复制链表的每个结点
        RandomListNode curr = pHead;
        while (curr != null) {
            RandomListNode pClone = new RandomListNode(curr.label);
            pClone.next = curr.next;
            pClone.random = null;
            curr.next = pClone;
            curr = pClone.next;
        }
        // 2. A2.random = A1.random.next
        curr = pHead;
        while (curr != null) {
            RandomListNode pClone = curr.next;
            if (curr.random != null) {
                pClone.random = curr.random.next;
            }
            curr = pClone.next;
        }
        // 3. 分拆链表
        curr = pHead;
        RandomListNode pCloneHead = curr.next;
        RandomListNode pCloneCurr = pCloneHead;
        curr.next = pCloneCurr.next;
        curr = pCloneCurr.next;
        while (curr != null) {
            pCloneCurr.next = curr.next;
            pCloneCurr = curr.next;
            curr.next = pCloneCurr.next;
            curr = pCloneCurr.next;
        }
        return pCloneHead;
    }

}
