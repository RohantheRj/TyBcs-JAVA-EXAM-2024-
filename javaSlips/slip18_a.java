public class ThreadInfo {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("Current Thread Name: " + thread.getName());
        System.out.println("Current Thread Priority: " + thread.getPriority());
    }
}

