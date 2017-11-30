package patterns;

import org.testng.annotations.Test;
import patterns.structural.flyweight_factory.SimpleShapeFactory;
import shapes.Shape;

import static org.testng.Assert.assertEquals;
import static shapes.Colors.GREEN;
import static shapes.Shapes.CIRCLE;
import static shapes.Shapes.TRIANGLE;

public class FactoryTest {

    @Test
    public void createsTriangle() {
        Shape shape = new SimpleShapeFactory().createShape(TRIANGLE, GREEN, .25);
        assertEquals(shape.getPerimeter(), 3.41421, .0001);
        assertEquals(shape.getArea(), .25, .0001);
    }

    @Test
    public void createsCircle() {
        Shape shape = new SimpleShapeFactory().createShape(CIRCLE);
        assertEquals(shape.getPerimeter(), 6.283185, .0001);
        assertEquals(shape.getArea(), 3.141592, .0001);
    }


}
