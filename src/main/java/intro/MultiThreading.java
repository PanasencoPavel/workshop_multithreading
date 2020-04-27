package intro;

public class MultiThreading {

    private static void getThread() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).start();
    }

    public static void main(String[] args) {

        getThread();

    }


}
