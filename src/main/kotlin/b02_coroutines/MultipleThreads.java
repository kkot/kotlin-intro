package b02_coroutines;

import java.util.ArrayList;
import java.util.List;

public class MultipleThreads {

    private void httpCall(int num) {
        System.out.println("(" + num + ") I'm working in thread " + Thread.currentThread().getName());
        sleep();
        System.out.print(".");
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void multipleThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20_000; i++) {
            int num = i;
            Thread thread = new Thread(() -> {
                httpCall(num);
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        new MultipleThreads().multipleThreads();

        long end = System.currentTimeMillis();

        long took = end - start;
        System.out.println("Took " + took + " milliseconds");
    }


}
