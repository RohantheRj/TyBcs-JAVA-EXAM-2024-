public class SynchronizationExample {

    public static void main(String[] args) {
        Counter counter = new Counter();


        Thread thread1 = new Thread(new IncrementTask(counter));
        Thread thread2 = new Thread(new IncrementTask(counter));


        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Final Count: " + counter.getCount());
    }

    static class Counter {
        private int count;

        public Counter() {
            this.count = 0;
        }

        public void increment() {
            synchronized (this) {

                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    static class IncrementTask implements Runnable {
        private final Counter counter;

        public IncrementTask(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }
}

