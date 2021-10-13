package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//创建线程四种方式：
public class HowToCreateThread {
    //方式一：
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }
    //方式二：
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }
    //方式三：
    static class MyCall implements Callable<String > {
        @Override
        public String call() {
            return "Hello Callable!";
        }
    }
    //方式四：（线程池）略
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //方式一：
        new MyThread().start();
        //方式二：
        new Thread(new MyRun()).start();
        new Thread(() -> {
            System.out.println("Hello Lambda!");
        }).start();
        //方式三：
        FutureTask<String> ft = new FutureTask<>(new MyCall());
        new Thread(ft).start();
        System.out.println(ft.get());
    }
}
