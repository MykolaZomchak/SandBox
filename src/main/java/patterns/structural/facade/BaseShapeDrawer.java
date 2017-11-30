package patterns.structural.facade;

import patterns.structural.decorator.ColoredShape;
import patterns.structural.flyweight_factory.FlyweightShapeFactory;
import patterns.structural.flyweight_factory.SimpleShapeFactory;
import shapes.*;

public abstract class BaseShapeDrawer implements ShapeDrawer {

    protected Shapes shape;
    private SimpleShapeFactory factory = new FlyweightShapeFactory();

    private Shape getShape(){
        if(shape.equals(Shapes.CIRCLE))
            return new Circle("circle", 10);
        if (shape.equals(Shapes.TRIANGLE))
            return new Triangle("triangle", 1,1,1);
        else
            throw new IllegalArgumentException("There is no such shape(" + shape.toString() + ")");
    }

    public void draw() {
        getShape().draw();
    }

    public void draw(int count) {
        while (count-- > 0) {
            draw();
        }
    }

    public void draw(Colors color) {
        Shape shapeToDraw = new ColoredShape(getShape(), color);
        shapeToDraw.draw();
    }

    public void draw(int count, Colors color) {
        while (count-- > 0) {
            draw(color);
        }
    }


}
