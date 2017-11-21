package patterns.structural.flyweight_factory;

import patterns.structural.decorator.ColoredShapeDecorator;
import patterns.structural.decorator.ShapeWithHolesDecorator;
import shapes.Colors;
import shapes.Shape;
import shapes.Shapes;

import java.util.HashMap;

public class FlyweightShapeFactory extends SimpleShapeFactory {

    private static final HashMap<Colors, Shape> shapeMap = new HashMap<>();

    SimpleShapeFactory simpleFactory = new SimpleShapeFactory();

    public Shape createShape(Shapes type) {
        return createShape(type, Colors.NO_COLOR);
    }

    public Shape createShape(Shapes type, Colors color) {

        Shape shape = shapeMap.get(color);

        if (shape == null) {
            shape = new ColoredShapeDecorator(simpleFactory.createShape(type), color);
            shapeMap.put(color, shape);
            System.out.println("Creating " + type + " of " + color + "this" + Colors.NO_COLOR + " color.");
        }

        return shape;
    }

    public Shape createShape(Shapes type, double holesArea) {
        return createShape(type, Colors.NO_COLOR, holesArea);
    }

    public Shape createShape(Shapes type, Colors color, double holesArea) {
        return new ShapeWithHolesDecorator(createShape(type, color), holesArea);
    }

}
