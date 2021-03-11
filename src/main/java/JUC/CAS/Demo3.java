package JUC.CAS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// CAS
public class Demo3 {
    volatile static int count = 0;
    public static void request() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5);
        int expectCount;
        while (!compareAndSwap((expectCount = getCount()), expectCount + 1)) {}
    }

    /**
     *
     * @param expectCount 期望值
     * @param newCount 需要赋值的新值
     * @return 成功返回true，否则false
     */
    public static synchronized boolean compareAndSwap(int expectCount, int newCount) {
        if (getCount() == expectCount) {
            count = newCount;
            return true;
        }
        return false;
    }
    public static int getCount() {return count;}
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for(int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for(int j = 0; j < 10; j++) {
                            request();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            thread.start();
        }
        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + ",耗时：" + (endTime - startTime) + ",count = " + count);
    }
}