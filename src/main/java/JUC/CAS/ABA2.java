package JUC.CAS;

import java.util.concurrent.atomic.AtomicStampedReference;

// AtomicStampedReference 解决ABA问题

public class ABA2 {
    public static AtomicStampedReference<Integer> a = new AtomicStampedReference(new Integer(1), 1);

    public static void main(String[] args) {
        Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("操作线程" + Thread.currentThread().getName() + ",初始值：" + a.getReference());
                try {
                    Integer expectReference = a.getReference();
                    Integer newReference = expectReference + 1;
                    Integer expectStamp = a.getStamp();
                    Integer newStamp = expectStamp + 1;

                    Thread.sleep(1000);
                    boolean isCASSuccess = a.compareAndSet(expectReference, newReference, expectStamp, newStamp);
                    System.out.println("操作线程" + Thread.currentThread().getName() + ",CAS操作：" + isCASSuccess);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "主线程");

        Thread other = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20);
                    a.compareAndSet(a.getReference(), a.getReference() + 1, a.getStamp(),a.getStamp() + 1);
                    System.out.println("操作线程" + Thread.currentThread().getName() + ",值=" + a.getReference());
                    a.compareAndSet(a.getReference(), a.getReference() - 1, a.getStamp(),a.getStamp() + 1);
                    System.out.println("操作线程" + Thread.currentThread().getName() + ",值=" + a.getReference());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "干扰线程");

        main.start();
        other.start();
    }
}
