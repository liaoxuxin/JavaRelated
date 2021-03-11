package JUC;

public class Synchronized_Test3 {
    int count = 0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while(true) {
            count ++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count == 5) {
                int i = 1/0; //此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch，然后让循环继续
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Synchronized_Test3 t = new Synchronized_Test3();
        new Thread(() -> {t.m();}, "t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {t.m();}, "t2").start();
    }
}

//程序在执行过程中，如果出现异常，默认情况锁会被释放