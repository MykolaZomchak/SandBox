package collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.structural.flyweight_factory.ShapeFactory;
import patterns.structural.flyweight_factory.SimpleShapeFactory;
import shapes.Circle;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.testng.Assert.*;

public class ListSmoke {

    private ShapeFactory factory = new SimpleShapeFactory();

    @DataProvider(name = "Lists")
    public static Object[][] lists() {
        return new Object[][]{{new SimpleArrayList<Shape>()}, {new SimpleLinkedList<Shape>()}};
    }

    private Shape newShape() {
        return new Circle("circle", Math.random());
    }

    @Test(dataProvider = "Lists")
    public void testAdd(List<Shape> list) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();

        assertTrue(list.isEmpty());
        list.add(0, shape2);
        assertEquals(list.size(), 1);
        list.add(0, shape1);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0), shape1);
        assertEquals(list.get(1), shape2);
    }

    @Test(dataProvider = "Lists")
    public void testAddAll(List<Shape> list) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();
        Shape shape3 = newShape();


        List<Shape> arrayList = new ArrayList<>();
        arrayList.add(shape1);
        arrayList.add(shape2);

        list.add(shape3);
        list.addAll(0, arrayList);

        assertTrue(list.containsAll(arrayList));
        assertEquals(list.get(2), shape3);
    }

    @Test(dataProvider = "Lists")
    public void testGet(List<Shape> list) {
        Shape shape = newShape();
        list.add(newShape());
        list.add(shape);

        assertEquals(list.get(1), shape);
    }

    @Test(dataProvider = "Lists")
    public void testSet(List<Shape> list) {
        Shape shape = newShape();
        list.add(newShape());
        list.add(newShape());
        list.set(1, shape);

        assertEquals(list.get(1), shape);
    }

    @Test(dataProvider = "Lists")
    public void testRemove(List<Shape> list) {
        Shape shape = newShape();
        list.add(shape);
        list.remove(shape);

        assertTrue(list.isEmpty());
    }

    @Test(dataProvider = "Lists")
    public void testIndexOf(List<Shape> list) {
        Shape shape = newShape();
        list.add(shape);
        list.add(shape);

        assertEquals(list.indexOf(shape), 0);
    }

    @Test(dataProvider = "Lists")
    public void testLastIndexOf(List<Shape> list) {
        Shape shape = newShape();
        list.add(shape);
        list.add(shape);

        assertEquals(list.lastIndexOf(shape), 1);
    }

    @Test(dataProvider = "Lists")
    public void testListIterator(List<Shape> list) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();
        Shape shape3 = newShape();

        list.add(shape1);
        list.add(shape2);
        list.add(shape3);

        ListIterator<Shape> iterator = list.listIterator();

        assertFalse(iterator.hasPrevious());
        assertEquals(iterator.next(), shape1);
        assertEquals(iterator.nextIndex(), 1);
        assertEquals(iterator.previousIndex(), 0);

        iterator.set(shape2);
        iterator.add(shape3);

        assertTrue(iterator.hasPrevious());
        assertEquals(iterator.previous(), shape3);
        assertEquals(iterator.previous(), shape2);
        assertEquals(list.get(1), shape3);
        assertEquals(list.get(0), shape2);
    }

}
