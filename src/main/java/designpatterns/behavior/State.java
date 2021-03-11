package designpatterns.behavior;

interface C {
    void f();
}

class C1 implements C {
    @Override
    public void f() {
        System.out.println("C1");
    }
}

class C2 implements C {
    @Override
    public void f() {
        System.out.println("C2");
    }
}

class C3 {
    C c = new C1();
    void f(String s) {
        if (s.length() > 5) {
            c = new C1();
        } else {
            c = new C2();
        }
        c.f();
    }
}

public class State {
    public static void main(String[] args) {
        C3 c = new C3();
        c.f("1111");
        c.f("22312313");
    }
}
