package ex2;

public class ThreadSafeStackTest {
    public static void main(String[] args) {
        ThreadSafeStack<Integer> stack = new ThreadSafeStack<>();

        // Thread to push elements onto the stack
        Thread pushThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                stack.push(i);
                try {
                    Thread.sleep(50); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Thread to pop elements from the stack
        Thread popThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                stack.pop();
                try {
                    Thread.sleep(100); // Simulate some delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start both threads
        pushThread.start();
        popThread.start();

        // Wait for both threads to complete
        try {
            pushThread.join();
            popThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All operations completed.");
    }
}
