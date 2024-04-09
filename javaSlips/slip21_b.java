import java.util.LinkedList;

public class ProducerConsumer {
    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int capacity = 5;

        Producer producer = new Producer(buffer, capacity);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {
        private final LinkedList<Integer> buffer;
        private final int capacity;
        private int value = 0;

        public Producer(LinkedList<Integer> buffer, int capacity) {
            this.buffer = buffer;
            this.capacity = capacity;
        }

        public void produce() throws InterruptedException {
            synchronized (buffer) {
                while (buffer.size() == capacity) {
                    System.out.println("Buffer is full. Waiting for consumer to consume...");
                    buffer.wait();
                }

                System.out.println("Producer produced: " + value);
                buffer.add(value++);
                Thread.sleep(1000); // Simulate some work
                buffer.notifyAll();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final LinkedList<Integer> buffer;

        public Consumer(LinkedList<Integer> buffer) {
            this.buffer = buffer;
        }

        public void consume() throws InterruptedException {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    System.out.println("Buffer is empty. Waiting for producer to produce...");
                    buffer.wait();
                }

                int val = buffer.removeFirst();
                System.out.println("Consumer consumed: " + val);
                Thread.sleep(1000); // Simulate some work
                buffer.notifyAll();
            }
        }

        @Override
        public void run() {
            while (true) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

