package shapes;

public class Triangle extends BaseShape {

    public Triangle(String description, double a, double b, double c) {
        super(description);
        perimeter = a + b + c;
        double p = perimeter/2;
        area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

}
