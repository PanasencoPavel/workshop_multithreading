package atomic;

import java.util.concurrent.atomic.AtomicInteger;

class SafeCounter implements Runnable {

    AtomicInteger count;

    SafeCounter() { count = new AtomicInteger(); }

    public  void run() {
        int max = 1000000;

        for (int i = 0; i < max; i++) {
            count.getAndIncrement();
        }
    }
}

public class AtomicCounter {
    public static void main(String[] args)
            throws InterruptedException {

        SafeCounter c = new SafeCounter();

        Thread first = new Thread(c, "First");
        Thread second = new Thread(c, "Second");

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(c.count);
    }
} 
