package ex3;

import java.util.Date;

public class Producer implements Runnable {
    private final SynchronizedQueue queue;

    public Producer(SynchronizedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            String item = new Date().toString();
            queue.add(item);
            try {
                Thread.sleep(100); // Simulate some delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
