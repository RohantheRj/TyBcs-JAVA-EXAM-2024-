public class slip6_b {
    private static final int RED_TIME = 5000;     // 5 seconds
    private static final int YELLOW_TIME = 2000;  // 2 seconds
    private static final int GREEN_TIME = 5000;   // 5 seconds

    public static void main(String[] args) {
        Thread redThread = new Thread(new RedSignal());
        Thread yellowThread = new Thread(new YellowSignal());
        Thread greenThread = new Thread(new GreenSignal());

        redThread.start();
        yellowThread.start();
        greenThread.start();
    }

    static class RedSignal implements Runnable {
        public void run() {
            while (true) {
                try {
                    System.out.println("Red Signal: Stop");
                    Thread.sleep(RED_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class YellowSignal implements Runnable {
        public void run() {
            while (true) {
                try {
                    System.out.println("Yellow Signal: Prepare to move");
                    Thread.sleep(YELLOW_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class GreenSignal implements Runnable {
        public void run() {
            while (true) {
                try {
                    System.out.println("Green Signal: Go");
                    Thread.sleep(GREEN_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

