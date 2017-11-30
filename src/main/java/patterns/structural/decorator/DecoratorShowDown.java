package patterns.structural.decorator;

import shapes.Circle;
import shapes.Colors;
import shapes.Shape;
import shapes.Triangle;

public class DecoratorShowDown {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];

        shapes[0] = new Circle("Circle", 10);
        shapes[1] = new ColoredShape(new Triangle("Triangle", 1,1,1), Colors.GREEN);
        shapes[2] = new ShapeWithHoles(new Circle("HoledCircle", 5), 3);
        shapes[3] = new ColoredShape(new ShapeWithHoles(new Circle("HoledCircle", 20), 10), Colors.RED);

        for(Shape shape: shapes)
            shape.draw();
    }

}
