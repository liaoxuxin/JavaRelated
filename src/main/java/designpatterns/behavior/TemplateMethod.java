package designpatterns.behavior;

abstract class A {
    void eat5times() {
        for (int i = 0; i < 5; i++) {
            eat();
            System.out.println("-------------------");
        }
    }
    abstract void eat();
}

public class TemplateMethod extends A {
    @Override
    void eat() {
        System.out.println("好吃！");
    }

    public static void main(String[] args) {
        A a = new TemplateMethod();
        a.eat5times();
    }
}
