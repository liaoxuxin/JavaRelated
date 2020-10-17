package JUC;

public class Synchronized_Test1 implements Runnable {
    private /*volatile*/ int count = 100;
    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
    public static void main(String[] args) {
        Synchronized_Test1 t = new Synchronized_Test1();
        for(int i=0; i<100; i++) {
            new Thread(t).start();
        }
    }
}

// 会有什么问题？