package shapes;

public abstract class BaseShape implements Shape {

    protected String description;
    protected double perimeter;
    protected double area;

    protected BaseShape(String description){
        this.description = description;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public void draw() { System.out.println(description);}

}
