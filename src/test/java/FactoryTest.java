import org.testng.annotations.Test;
import patterns.structural.factory.ShapeFactory;
import shapes.Shape;
import patterns.structural.factory.ShapeSizes;
import patterns.structural.factory.Shapes;

import static org.testng.Assert.assertEquals;

public class FactoryTest {

    @Test
    public void createsTriangle(){
        Shape shape = new ShapeFactory().createShape(Shapes.RECTANGULAR_TRIANGLE, ShapeSizes.SMALL);
        assertEquals(shape.getPerimeter(), 3.41421, .0001);
        assertEquals(shape.getArea(), .5, .0001);
    }

    @Test
    public void createsCircle(){
        Shape shape = new ShapeFactory().createShape(Shapes.CIRCLE, ShapeSizes.SMALL);
        assertEquals(shape.getPerimeter(), 6.283185, .0001);
        assertEquals(shape.getArea(), 3.141592, .0001);
    }


}
