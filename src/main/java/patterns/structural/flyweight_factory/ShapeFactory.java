package patterns.structural.flyweight_factory;

import shapes.Colors;
import shapes.Shape;
import shapes.Shapes;

public abstract class ShapeFactory {

    protected final double size = 1;

    public abstract Shape createShape(Shapes type);

    public abstract Shape createShape(Shapes type, Colors color);

    public abstract Shape createShape(Shapes type, double holesArea);

    public abstract Shape createShape(Shapes type, Colors color, double holesArea);

}
