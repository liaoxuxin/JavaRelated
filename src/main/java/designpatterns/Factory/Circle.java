package designpatterns.Factory;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

    @Override
    public int cnt() {
        return 1;
    }
}