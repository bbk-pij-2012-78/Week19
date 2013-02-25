/**
 * Created with IntelliJ IDEA.
 * User: Nick
 * Date: 25/02/13
 * Time: 18:42

 */

public class Increaser implements Runnable {
    private Counter c;
    public Increaser(Counter counter) {
        this.c = counter;
    }
    public static void main(String args[]) {
        Counter counter = new Counter();
        for (int i = 0; i < 100; i++) {
            Increaser increaserTask = new Increaser(counter);
            Thread t = new Thread(increaserTask);
            t.start();
        }
    }
    public void run() {
        synchronized (c) {
            System.out.println("Starting at " + c.getCount());
            for (int i = 0; i < 1000; i++) {
                    c.increase();
            }
            System.out.println("Stopping at " + c.getCount());
        }
    }
}
