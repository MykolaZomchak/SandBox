package shapes;

public abstract class BaseShape implements Shape {

    protected String description;
    protected double perimeter;
    protected double area;

    protected BaseShape(String description) {
        this.description = description;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public void draw() { System.out.println(description);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseShape)) return false;

        BaseShape baseShape = (BaseShape) o;

        if (Double.compare(baseShape.getPerimeter(), getPerimeter()) != 0) return false;
        if (Double.compare(baseShape.getArea(), getArea()) != 0) return false;
        return description.equals(baseShape.description);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = description.hashCode();
        temp = Double.doubleToLongBits(getPerimeter());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getArea());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
