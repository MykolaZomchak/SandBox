package patterns.creational.abstract_factory;

import shapes.Circle;
import shapes.Triangle;

public class BigShapesFactory implements ShapesFactory {
    @Override
    public Circle makeCircle() {
        return new Circle("circle", 100);
    }

    @Override
    public Triangle makeTriangle() {
        return new Triangle("triangle", 100, 100, 100);
    }
}
