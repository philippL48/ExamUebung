import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MultiThreading {
    public static int counter;

    public static void main(String args[]) {
        try {
            Thread t1 = new Thread(new CounterThread("t1"));
            t1.start();
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1));
            Thread t2 = new Thread(new CounterThread("t2"));
            t2.start();
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1));
            Thread t3 = new Thread(new CounterThread("t3"));
            t3.start();
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1));
            Thread t4 = new Thread(new CounterThread("t4"));
            t4.start();
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1));
            Thread t5 = new Thread(new CounterThread("t5"));
            t5.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void increment() {
        counter++;
    }

}
