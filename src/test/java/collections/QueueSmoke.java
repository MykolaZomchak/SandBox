package collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.structural.flyweight_factory.ShapeFactory;
import patterns.structural.flyweight_factory.SimpleShapeFactory;
import shapes.Circle;
import shapes.Shape;

import java.util.Queue;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class QueueSmoke {

    private ShapeFactory factory = new SimpleShapeFactory();

    @DataProvider(name = "Queues")
    public static Object[][] lists() {
        return new Object[][]{{new SimpleLinkedList<Shape>()}};
    }

    private Shape newShape() {
        return new Circle("circle", Math.random());
    }

    @Test(dataProvider = "Queues")
    public void testOffer(Queue<Shape> queue) {

        Shape shape1 = newShape();
        Shape shape2 = newShape();

        assertTrue(queue.isEmpty());
        assertTrue(queue.offer(shape2));
        assertEquals(queue.size(), 1);
        queue.offer(shape1);
        assertEquals(queue.size(), 2);
        assertTrue(queue.contains(shape1));
        assertTrue(queue.contains(shape2));
    }

    @Test(dataProvider = "Queues")
    public void testRemove(Queue<Shape> queue) {
        queue.add(newShape());
        queue.remove();
        assertTrue(queue.isEmpty());
    }

    @Test(dataProvider = "Queues")
    public void testPoll(Queue<Shape> queue) {
        queue.add(newShape());
        queue.poll();
        assertTrue(queue.isEmpty());
    }

    @Test(dataProvider = "Queues")
    public void testElement(Queue<Shape> queue) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();

        queue.add(shape1);
        assertEquals(queue.element(), shape1);
        queue.add(shape2);
        assertEquals(queue.element(), shape2);
        queue.remove();
        assertEquals(queue.element(), shape1);

    }

    @Test(dataProvider = "Queues")
    public void testPeek(Queue<Shape> queue) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();

        queue.add(shape1);
        assertEquals(queue.peek(), shape1);
        queue.add(shape2);
        assertEquals(queue.peek(), shape2);
        queue.remove();
        assertEquals(queue.peek(), shape1);
    }

}
