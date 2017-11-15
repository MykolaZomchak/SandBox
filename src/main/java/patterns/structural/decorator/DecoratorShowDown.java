package patterns.structural.decorator;

import patterns.structural.factory.ShapeFactoryImpl;
import shapes.Colors;
import shapes.Shapes;

public class DecoratorShowDown {

    public static void main(String[] args){
        ShapeFactoryImpl factory = new ShapeFactoryImpl();
        factory.createShape(Shapes.TRIANGLE, Colors.GREEN, .25).draw();
        factory.createShape(Shapes.TRIANGLE, Colors.BLUE).draw();
        factory.createShape(Shapes.TRIANGLE, Colors.RED).draw();
        factory.createShape(Shapes.TRIANGLE).draw();
    }

}
