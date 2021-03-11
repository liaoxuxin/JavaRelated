package designpatterns.behavior;

interface B {
    void eat();
}

class B1 implements B {
    @Override
    public void eat() {
        System.out.println("B1好吃");
    }
}

class B2 implements B {
    @Override
    public void eat() {
        System.out.println("B2好吃");
    }
}

public class Strategy {
    B b = new B1();
    void setStrategy(B b) {
        this.b = b;
    }
    void f() {
        b.eat();
    }
    public static void main(String[] args) {
        Strategy s = new Strategy();
        s.f();
        s.setStrategy(new B2());
        s.f();
    }
}
