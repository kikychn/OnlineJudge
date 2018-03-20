package online_judge;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 * 注：典型的后进先出，可以考虑用栈实现
 */
public class PrintListFromTailToHead_5 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ArrayList<Integer> arrlist1 = new ArrayList<Integer>();// 用于递归方法中
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        /* method1,递归 */
//        if (listNode == null)
//            return arrlist1;
//
//        printListFromTailToHead(listNode.next);
//        arrlist1.add(listNode.val);
//        return arrlist1;

        /* method2,循环 */
        ArrayList<Integer> arrlist2 = new ArrayList<Integer>();
        if (listNode == null)
            return arrlist2;

        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrlist2.add(stack.pop());
        }
        return arrlist2;
    }
    
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = null;

        listNode2.next = listNode3;
        listNode3.next = listNode4;

        // ArrayList newarr = printListFromTailToHead(listNode1);
        ArrayList newarr = printListFromTailToHead(listNode2);
        // ArrayList newarr = printListFromTailToHead(listNode5);

        for (int i = 0; i < newarr.size(); ++i) {
            System.out.print(newarr.get(i) + " ");
        }
    }

}
