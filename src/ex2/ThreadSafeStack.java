package ex2;

public class ThreadSafeStack<T> {
    // Node class for the linked list
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top; // Top of the stack

    // Synchronized method to push an element onto the stack
    public synchronized void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + value);
    }

    // Synchronized method to pop an element from the stack
    public synchronized T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop.");
            return null;
        }
        T value = top.data;
        top = top.next;
        System.out.println("Popped: " + value);
        return value;
    }

    // Synchronized method to check if the stack is empty
    public synchronized boolean isEmpty() {
        return top == null;
    }
}
