
class MyStack<T> {
    private Object[] data;
    private int top;

    public MyStack(int size) {
        data = new Object[size];
        top = -1;
    }

    public void push(T value) {
        if (top == data.length - 1) {
            System.out.println("Stack is full");
            return;
        }

        data[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }

        T value = (T) data[top];
        data[top] = null;
        top--;

        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class GenericStackDemo {

    public static void main(String[] args) {

        // Stack of Strings
        MyStack<String> names = new MyStack<>(3);
        names.push("Dwij");
        names.push("Patel");

        System.out.println("String Stack:");
        System.out.println(names.pop());
        System.out.println(names.pop());
        System.out.println(names.pop());

        // Stack of Integers
        MyStack<Integer> numbers = new MyStack<>(3);
        numbers.push(10);
        numbers.push(20);

        System.out.println("Integer Stack:");
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());

        System.out.println("25CE077 - Dwij");
    }
}
