package patterns.creational.abstract_factory;

import shapes.Circle;
import shapes.Triangle;

public interface ShapesFactory {

    Circle makeCircle();
    Triangle makeTriangle();

}
