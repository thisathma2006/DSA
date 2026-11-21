import java.util.Stack;

public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }


    public void enqueue(int value){

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        System.out.println(value + " enqueued");
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        int removed = queue[front];

        front = (front + 1) % capacity;
        size--;

        return removed;
    }


    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args){

        ArrayCircularQueue q = new ArrayCircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Removed: " + q.dequeue());

        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Front: " + q.peek());

        q.display();
    }
}
