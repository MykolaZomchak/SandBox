import org.testng.annotations.Test;
import patterns.structural.factory.ShapeFactory;
import shapes.Colors;
import shapes.Shape;
import shapes.Shapes;

import static org.testng.Assert.assertEquals;

public class FactoryTest {

    @Test
    public void createsTriangle(){
        Shape shape = new ShapeFactory().createShape(Shapes.TRIANGLE, Colors.GREEN, .25);
        assertEquals(shape.getPerimeter(), 3.41421, .0001);
        assertEquals(shape.getArea(), .25, .0001);
    }

    @Test
    public void createsCircle(){
        Shape shape = new ShapeFactory().createShape(Shapes.CIRCLE);
        assertEquals(shape.getPerimeter(), 6.283185, .0001);
        assertEquals(shape.getArea(), 3.141592, .0001);
    }


}
