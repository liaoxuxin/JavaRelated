package designpatterns;

public class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton() {};

    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}

//饿汉式
