package designpatterns.Factory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    @Override
    public int cnt() {
        return 4;
    }
}
