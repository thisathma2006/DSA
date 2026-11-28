import java.util.Stack;
public class LinkedListFIFOQueue{

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    Node front = null;
    Node rear = null;

    public void enqueue(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(data + " added to queue");
    }

    public void dequeue() {

        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println(front.data + " removed from queue");

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    public void peek() {

        if (front == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {

        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = front;

        System.out.print("Queue: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args){

        LinkedListFIFOQueue queue =
                new LinkedListFIFOQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        queue.peek();
        queue.dequeue();
        queue.display();
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
