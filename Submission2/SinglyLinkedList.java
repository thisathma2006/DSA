import java.util.Stack;
public class SinglyLinkedList{

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void insertFirst(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertAfter(int key, int data) {

        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Value not found");
            return;
        }

        Node newNode = new Node(data);

        newNode.next = current.next;
        current.next = newNode;
    }

    public void delete(int key) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != key) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found");
            return;
        }

        current.next = current.next.next;
    }

    public boolean search(int key) {

        Node current = head;

        while (current != null) {

            if (current.data == key) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void display() {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(20);
        list.insertFirst(10);
        list.insertLast(30);

        list.display();

        list.insertAfter(20, 25);
        list.display();

        list.delete(25);
        list.display();

        System.out.println("Found 30: " + list.search(30));
    }
}
