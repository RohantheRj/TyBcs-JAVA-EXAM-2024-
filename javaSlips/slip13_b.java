import java.util.Random;

public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        Thread thread1 = new MyThread("Thread 1");
        Thread thread2 = new MyThread("Thread 2");

        thread1.start();
        thread2.start();
    }

    static class MyThread extends Thread {
        private String threadName;
        private Random random = new Random();

        public MyThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadName + " created.");

            try {
                int sleepTime = random.nextInt(5000); 
                System.out.println("Thread " + threadName + " will sleep for " + sleepTime + " milliseconds.");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }

            System.out.println("Thread " + threadName + " is dead.");
        }
    }
}

