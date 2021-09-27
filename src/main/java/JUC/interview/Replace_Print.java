package JUC.interview;

//两个线程交替打印1-10
public class Replace_Print {
    private volatile int num = 1;
    public synchronized void print1() throws InterruptedException {
        while (num < 10) {
            if (num % 2 == 0) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + ": "  + num);
            num++;
            this.notify();
        }
    }
    public synchronized void print2() throws InterruptedException {
        while (num < 10) {
            if (num % 2 == 1) {
                this.wait();
            }
            System.out.println(Thread.currentThread().getName() + ": "  + num);
            num++;
            this.notify();
        }
    }

    public static void main(String[] args) {
        Replace_Print rp = new Replace_Print();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rp.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    rp.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
