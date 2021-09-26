package JUC.interview;

import java.util.concurrent.locks.*;

//一个对象的生产者，消费者模型
public class Producer_Consumer {

    private Object object;
    private Lock lock = new ReentrantLock();
    private Condition nullCondition = lock.newCondition();
    private Condition notNullConditon = lock.newCondition();

    public void put(Object ob) throws InterruptedException {
        lock.lock();
        if (object == null) {
            object = ob;
            notNullConditon.signal();
        } else {
            System.out.println("put阻塞中。。。");
            nullCondition.await();
            object = ob;
        }
        lock.unlock();
    }

    public Object take() throws InterruptedException {
        lock.lock();
        if (object == null) {
            System.out.println("take阻塞中。。。");
            notNullConditon.await();
            return object;
        } else {
            Object tmp = object;
            object = null;
            nullCondition.signal();
            lock.unlock();
            return tmp;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Producer_Consumer pc = new Producer_Consumer();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        pc.put(new Object());
                        System.out.println("put " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(pc.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
