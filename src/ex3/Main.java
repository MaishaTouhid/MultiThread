package ex3;

public class Main {
    public static void main(String[] args) {
        SynchronizedQueue queue = new SynchronizedQueue();

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Producer and Consumer threads have finished.");
    }
}

