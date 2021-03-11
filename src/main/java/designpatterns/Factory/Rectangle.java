package designpatterns.Factory;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }

    @Override
    public int cnt() {
        return 4;
    }
}
