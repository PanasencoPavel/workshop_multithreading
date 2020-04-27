package synchronization;

class SyncDemo {
    public static void main(String args[]) {
        Sender snd = new Sender();
        ThreadedSend S1 = new ThreadedSend(" Hi ", snd);
        ThreadedSend S2 = new ThreadedSend(" Bye ", snd);

        S1.start();
        S2.start();

        try {
            S1.join();
            S2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }

}

class ThreadedSend extends Thread {

    private String msg;
    private Sender sender;

    ThreadedSend(String m, Sender obj) {
        msg = m;
        sender = obj;
    }

    @Override
    public void run() {
//        synchronized (Sender.class) {
            sender.send(msg);
//        }
    }
}

class Sender {

    public synchronized void send(String msg) {
        System.out.println("Sending\t" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}
