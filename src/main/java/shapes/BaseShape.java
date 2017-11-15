package shapes;

public abstract class BaseShape implements Shape {

    protected double perimeter;
    protected double area;


    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
