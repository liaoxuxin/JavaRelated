package JUC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    AtomicInteger count = new AtomicInteger(0);

    void f() {
        for (int i = 0; i < 10000; i++)
            count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest t = new AtomicIntegerTest();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::f, "thread-" + i));
        }
        for (int i = 0; i < 10; i++) {
            threads.get(i).start();
        }
        for (int i = 0; i < 10; i++) {
            threads.get(i).join();
        }
        System.out.println(t.count);
    }
}
