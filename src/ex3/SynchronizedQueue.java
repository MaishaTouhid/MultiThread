package ex3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Date;

public class SynchronizedQueue {
    private final Queue<String> queue = new LinkedList<>();
    private final int MAX_CAPACITY = 10;

    // Synchronized method to add an element to the queue
    public synchronized void add(String item) {
        while (queue.size() >= MAX_CAPACITY) {
            try {
                wait(); // Wait until there is space in the queue
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(item);
        System.out.println("Added: " + item);
        notifyAll(); // Notify waiting threads
    }

    // Synchronized method to remove an element from the queue
    public synchronized String remove() {
        while (queue.isEmpty()) {
            try {
                wait(); // Wait until there is something in the queue
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        String item = queue.remove();
        System.out.println("Removed: " + item);
        notifyAll(); // Notify waiting threads
        return item;
    }
}
