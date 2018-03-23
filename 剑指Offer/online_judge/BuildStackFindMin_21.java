package online_judge;
/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
import java.util.Stack;

public class BuildStackFindMin_21 {
    
    public static class BuildStack {
        public Stack<Integer> stack = new Stack<Integer>();
        public Stack<Integer> stack_assist = new Stack<Integer>();

        public void push(int node) {
            stack.push(node);
            if (stack_assist.isEmpty() || node <= stack_assist.peek())
                stack_assist.add(node);
            else
                stack_assist.add(stack_assist.peek());
        }

        public void pop() {
            stack.pop();
            stack_assist.pop();
        }

        public int top() {
            return stack.peek(); 
        }

        public int min() {
            return stack_assist.peek();
        }
    }

    public static void main(String[] args) {
        BuildStack s = new BuildStack();
        s.push(2);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.push(3);
        System.out.println(s.min());
        s.push(1);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
    }

}
