package atomic;


public class UnSafeCounter {

    public static void main(String[] args)
            throws InterruptedException {
        Counter c = new Counter();

        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(c.count);
    }
}


class Counter implements Runnable {

    int count = 0;

    public void run() {
        int max = 1000000;

        for (int i = 0; i < max; i++) {
            count++;
        }
    }
}
