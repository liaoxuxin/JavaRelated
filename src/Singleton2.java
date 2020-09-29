public class Singleton2 {
    private static volatile Singleton2 singleton;

    private Singleton2() {}

    public static Singleton2 getInstance() {
        if (singleton == null) {
            synchronized (Singleton2.class) {
                if(singleton == null) {
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton2 singleton1 = Singleton2.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}

//懒汉式，双重检查