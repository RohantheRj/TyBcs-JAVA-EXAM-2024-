public class ThreadInfo {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Current Thread: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
    }
}

