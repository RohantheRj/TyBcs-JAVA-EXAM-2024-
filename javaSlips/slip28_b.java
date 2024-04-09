public class CurrentThreadName {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyRunnable(), "Thread-1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread-2");

        thread1.start();
        thread2.start();


        String mainThreadName = Thread.currentThread().getName();
        System.out.println("Main thread name: " + mainThreadName);
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {

            String currentThreadName = Thread.currentThread().getName();
            System.out.println("Current thread name: " + currentThreadName);
        }
    }
}

