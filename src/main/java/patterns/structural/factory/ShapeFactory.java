package patterns.structural.factory;

import shapes.*;

public class ShapeFactory {

    public Shape createShape(Shapes type, ShapeSizes size) {
        if (type == Shapes.CIRCLE) {
            return new Circle(size.toInt());
        }
        if (type == Shapes.RECTANGULAR_TRIANGLE) {
            return new Triangle(size.toInt(), size.toInt(), size.toInt() * Math.sqrt(2));
        }
        if (type == Shapes.EQUILATERAL_TRIANGLE) {
            return new Triangle(size.toInt(), size.toInt(), size.toInt());
        }
        throw new IllegalArgumentException("There is no such shape(" + type.toString() + ")");
    }

}
