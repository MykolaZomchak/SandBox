package shapes;

import static java.lang.Math.PI;

public class Circle extends BaseShape {

    public Circle(double radius) {
        perimeter = 2 * radius * PI;
        area = radius*radius * PI;
    }
}
