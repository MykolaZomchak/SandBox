package patterns.structural.flyweight_factory;

import patterns.structural.decorator.ColoredShape;
import patterns.structural.decorator.ShapeWithHoles;
import shapes.*;

public class SimpleShapeFactory extends ShapeFactory {

    public Shape createShape(Shapes type) {
        String description = type.toString().charAt(0) + type.toString().toLowerCase().substring(1);
        if (type == Shapes.CIRCLE) {
            return new Circle(description, size);
        }
        if (type == Shapes.TRIANGLE) {
            return new Triangle(description, size, size, size * Math.sqrt(2));
        }
        throw new IllegalArgumentException("There is no such shape(" + type.toString() + ")");
    }

    public Shape createShape(Shapes type, Colors color) {
        return new ColoredShape(createShape(type), color);
    }

    public Shape createShape(Shapes type, double holesArea) {
        return new ShapeWithHoles(createShape(type), holesArea);
    }

    public Shape createShape(Shapes type, Colors color, double holesArea) {
        return new ColoredShape(createShape(type, holesArea), color);
    }

}
