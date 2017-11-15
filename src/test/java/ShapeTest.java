import org.testng.Assert;
import org.testng.annotations.Test;
import shapes.Circle;
import shapes.Shape;
import shapes.Triangle;

import static org.testng.Assert.assertEquals;

public class ShapeTest {

    @Test
    public void TriangleTest(){
        Shape shape = new Triangle(1,1,1.41421);
        assertEquals(shape.getPerimeter(), 3.41421, .0001);
        assertEquals(shape.getArea(), .5, .0001);
    }

    @Test
    public void CircleTest(){
        Shape shape = new Circle(1);
        assertEquals(shape.getPerimeter(), 6.283185, .0001);
        assertEquals(shape.getArea(), 3.141592, .0001);
    }
}
