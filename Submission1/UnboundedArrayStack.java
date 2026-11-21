
import java.util.Arrays;

public class UnboundedArrayStack{

    private int[] array;
    private int top;
    private static final int MIN_CAPACITY = 2;

    public UnboundedArrayStack(){
        array = new int[MIN_CAPACITY];
        top = -1;
    }

    private void resize(int newCapacity) {
        array = Arrays.copyOf(array, newCapacity);
    }

    public void push(int value) {

        if (top == array.length - 1) {
            resize(array.length * 2);
        }

        array[++top] = value;
        System.out.println(value + " pushed");
    }

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int removed = array[top];
        array[top] = 0;
        top--;

        if (array.length > MIN_CAPACITY &&
            size() <= array.length / 4) {

            resize(Math.max(MIN_CAPACITY, array.length / 2));
        }

        return removed;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int capacity() {
        return array.length;
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack =
            new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);

        System.out.println("Capacity: " + stack.capacity());

        stack.push(30);

        System.out.println("Capacity: " + stack.capacity());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        System.out.println("Capacity: " + stack.capacity());
    }
}
