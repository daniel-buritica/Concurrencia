import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread first = new Thread(counter,"first");
        Thread second = new Thread(counter, "second");
        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(counter.count);
    }

    static class Counter extends Thread {
        // Se usa AtomicInteger para evitar el bloqueo al sobre escribir una variable por dos procesos
        public AtomicInteger count = new AtomicInteger(0);

        public void run() {
            for (int i = 0; i < 100_000_000; i++) {
                count.addAndGet(1);
            }

        }
    }
}
