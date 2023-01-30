import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

public class CounterThread extends Thread {

    String name;


    public CounterThread(String name) {
        this.name = name;
    }
    public void run() {


            try {
                while (MultiThreading.counter < 43) {
                    System.out.println("Thread: " + name + " Counter:" + MultiThreading.counter);
                    MultiThreading.increment();
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


}
