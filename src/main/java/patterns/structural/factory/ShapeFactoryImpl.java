package patterns.structural.factory;

import patterns.structural.decorator.ColoredShapeDecorator;
import patterns.structural.decorator.ShapeWithHolesDecorator;
import shapes.*;

public class ShapeFactoryImpl extends ShapeFactory {

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

    public Shape createShape(Shapes type, Colors color){
        return new ColoredShapeDecorator(createShape(type), color);
    }

    public Shape createShape(Shapes type, double holesArea){
        return new ShapeWithHolesDecorator(createShape(type), holesArea);
    }

    public Shape createShape(Shapes type, Colors color, double holesArea){
        return new ColoredShapeDecorator(createShape(type, holesArea), color);
    }

}
