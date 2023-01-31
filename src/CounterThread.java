import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

public class CounterThread extends Thread {

    public static String name;
    public static int counter;


    public CounterThread(String name) {
        this.name = name;
    }
    public void run() {


            try {
                while (counter < 42) {

                    increment();
                    Thread.sleep(1000, 3000);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    public synchronized static void increment() {

        counter++;
        System.out.println("Thread: " + name + " Counter:" + counter);
    }


}
