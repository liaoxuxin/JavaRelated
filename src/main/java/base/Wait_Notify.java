package base;
//两个线程交替打印1-100
public class Wait_Notify {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number,"线程1");
        Thread t2 = new Thread(number,"线程2");
        t1.start();
        t2.start();
    }
}

class Number implements Runnable{

    private int i = 0;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                if(i < 100){
                    i++;
                    System.out.println(Thread.currentThread().getName()+"---"+i);
                }else{
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
