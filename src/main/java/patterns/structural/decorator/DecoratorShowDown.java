package patterns.structural.decorator;

import patterns.structural.flyweight_factory.SimpleShapeFactory;
import shapes.Colors;
import shapes.Shapes;

public class DecoratorShowDown {

    public static void main(String[] args) {
        SimpleShapeFactory factory = new SimpleShapeFactory();                      // I combined decorator with factory
        factory.createShape(Shapes.TRIANGLE, Colors.GREEN, .25).draw();  // so objects are actually decorated
        factory.createShape(Shapes.TRIANGLE, Colors.BLUE).draw();                 // in SimpleShapeFactory class
        factory.createShape(Shapes.TRIANGLE, Colors.RED).draw();
        factory.createShape(Shapes.TRIANGLE).draw();
    }

}
