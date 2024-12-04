package ex3;

public class Consumer implements Runnable {
    private final SynchronizedQueue queue;

    public Consumer(SynchronizedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            queue.remove();
            try {
                Thread.sleep(150); // Simulate some delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

