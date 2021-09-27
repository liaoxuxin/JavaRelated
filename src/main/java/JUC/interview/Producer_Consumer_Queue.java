package JUC.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//生产者，消费者模型队列
public class Producer_Consumer_Queue {
    private Lock lock = new ReentrantLock();
    private Condition notnullCondition = lock.newCondition();
    private Condition notfullCondition = lock.newCondition();
    private Queue<Integer> q = new LinkedList<>();
    private int capacity;
    private AtomicInteger size = new AtomicInteger(0);

    public Producer_Consumer_Queue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (size.get() == capacity) {
                notfullCondition.await();
            }
            q.offer(element);
            size.incrementAndGet();
            notnullCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size.get() == 0) {
                notnullCondition.await();
            }
            int tmp = q.poll();
            size.decrementAndGet();
            notfullCondition.signal();
            return tmp;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size.get();
        } finally {
            lock.unlock();
        }
    }
}
