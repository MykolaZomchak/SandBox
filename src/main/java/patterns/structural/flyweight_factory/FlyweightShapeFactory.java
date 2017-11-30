package patterns.structural.flyweight_factory;

import patterns.structural.decorator.ColoredShape;
import patterns.structural.decorator.ShapeWithHoles;
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
            shape = new ColoredShape(simpleFactory.createShape(type), color);
            shapeMap.put(color, shape);
            System.out.println("Creating " + type + " of " + color + "this" + Colors.NO_COLOR + " color.");
        }

        return shape;
    }

    public Shape createShape(Shapes type, double holesArea) {
        return createShape(type, Colors.NO_COLOR, holesArea);
    }

    public Shape createShape(Shapes type, Colors color, double holesArea) {
        return new ShapeWithHoles(createShape(type, color), holesArea);
    }

}
