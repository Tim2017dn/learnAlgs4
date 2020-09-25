package other;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class t1 {
    public static void main(String[] args) {
      test2();
    }


    public static void test1(){
        Deque stack =new LinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3.1415);

        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.peek());
    }

    public static void test2(){
        Queue queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
