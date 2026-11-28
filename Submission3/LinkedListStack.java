import java.util.Stack;
public class LinkedListStack {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node top = null;

    public void push(int data) {

        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        System.out.println(data + " pushed into stack");
    }

    public void pop() {

        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println(top.data + " popped from stack");

        top = top.next;
    }

    public void peek() {

        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element: " + top.data);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {

        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node current = top;

        System.out.print("Stack: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.peek();
        stack.pop();
        stack.display();

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
