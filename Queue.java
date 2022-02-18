// Queue with two stacks. Implement a queue with two stacks so that each queue operations takes a
// constant amortized number of stack operations. Hint: If you push elements onto a stack and then 
// pop them all, they appear in reverse order. If you repeat this process, they're now back in order.
import java.io.*;
import java.lang.invoke.ClassSpecializer.Factory;
import java.util.*;

public class Stack{
    private Node first;
    private int size=0;

    private class Node{
        String item;
        Node next;
    }

    public void push(String item){
        Node oldfirst=first;
        first = new Node();
        first.item=item;
        first.next=oldfirst;
        size++;
    }

    public String pop()
    {
        if(isEmpty()) throw new NoSuchElementException("Stack Undeflow");
        String item=first.item;
        first=first.next;
        size--;
        return item;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size()
    {
        return size;
    }


}

class Queue {

    private Stack stack1,stack2;

    public Queue(String item) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
    }

    // Push element x to the back of queue.
    // o(N) Use 2 stack so space can be 2*number of elements
    public void enqueue(int x) {
        while(!stack1.isEmpty()) stack2.push(stack1.pop());
        stack1.push(x);
        while(!stack2.isEmpty())  stack1.push(stack2.pop());
    }

    // Removes the element from in front of queue.
    public int dequeue() {
        return 0;
    }
    
    // Get the front element.
    public int peek() {
        
    }
    
    // Return whether the queue is empty.
    public boolean empty() {
        return False;

    }

    // Return the number of elements in queue.
    public int size() {
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue queue = new Queue();
        int queries = Integer.parseInt(scan.nextLine());
        for(int i = 0; i < queries; i++) {
            String input = scan.nextLine();
            if (input.charAt(0) == '1') {
                String[] tokens = input.split(" ");
                queue.enqueue(Integer.parseInt(tokens[1]));
            } else if (input.charAt(0) == '2') {
                queue.dequeue();
            } else if (input.charAt(0) == '3') {
                System.out.println(queue.peek());
            } 
        }
    }
}
