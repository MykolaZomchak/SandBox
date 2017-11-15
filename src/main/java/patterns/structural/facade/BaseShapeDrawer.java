package patterns.structural.facade;

import patterns.structural.factory.ShapeFactoryImpl;
import shapes.Colors;
import shapes.Shapes;

public abstract class BaseShapeDrawer implements ShapeDrawer{

    private ShapeFactoryImpl factory = new ShapeFactoryImpl();
    protected Shapes shape;

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
