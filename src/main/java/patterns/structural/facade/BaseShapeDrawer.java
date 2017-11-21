package patterns.structural.facade;

import patterns.structural.flyweight_factory.FlyweightShapeFactory;
import patterns.structural.flyweight_factory.SimpleShapeFactory;
import shapes.Colors;
import shapes.Shapes;

public abstract class BaseShapeDrawer implements ShapeDrawer {

    protected Shapes shape;
    private SimpleShapeFactory factory = new FlyweightShapeFactory();

    public void draw() {
        factory.createShape(shape).draw();
    }

    public void draw(int count) {
        while (count-- > 0) {
            draw();
        }
    }

    public void draw(Colors color) {
        factory.createShape(shape, color).draw();
    }

    public void draw(int count, Colors color) {
        while (count-- > 0) {
            draw(color);
        }
    }


}
