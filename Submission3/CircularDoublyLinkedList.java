import java.util.Stack;
public class CircularDoublyLinkedList {


    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    public void insertEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            Node last = head.prev;

            last.next = newNode;
            newNode.prev = last;

            newNode.next = head;
            head.prev = newNode;
        }
    }

    public void displayForward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        System.out.print("Forward: ");

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }

    public void displayBackward() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head.prev;

        System.out.print("Backward: ");

        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != head.prev);

        System.out.println();
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list =
                new CircularDoublyLinkedList();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertEnd(40);

        list.displayForward();
        list.displayBackward();
    }
}
