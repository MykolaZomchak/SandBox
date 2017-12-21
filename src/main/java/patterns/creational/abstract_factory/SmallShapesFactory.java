package patterns.creational.abstract_factory;

import shapes.Circle;
import shapes.Triangle;

public class SmallShapesFactory implements ShapesFactory {
    @Override
    public Circle makeCircle() {
        return new Circle("circle", 1);
    }

    @Override
    public Triangle makeTriangle() {
        return new Triangle("triangle", 1, 1, 1);
    }
}
