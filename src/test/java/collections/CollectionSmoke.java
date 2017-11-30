package collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.structural.flyweight_factory.ShapeFactory;
import patterns.structural.flyweight_factory.SimpleShapeFactory;
import shapes.Circle;
import shapes.Shape;

import java.util.*;

import static org.testng.Assert.*;

public class CollectionSmoke {
    private ShapeFactory factory = new SimpleShapeFactory();

    @DataProvider(name = "Collections")
    public static Object[][] collections() {
        return new Object[][]{{new SimpleArrayList<Shape>()}, {new SimpleLinkedList<Shape>()}};
    }

    private Shape newShape() {
        return new Circle("circle", Math.random());
    }

    @Test(dataProvider = "Collections")
    public void testSize(Collection<Shape> collection) {
        assertEquals(collection.size(), 0);
        collection.add(newShape());
        assertEquals(collection.size(), 1);
    }

    @Test(dataProvider = "Collections")
    public void testIsEmpty(Collection<Shape> collection) {
        Shape shape = newShape();
        assertTrue(collection.isEmpty());
        collection.add(shape);
        assertFalse(collection.isEmpty());
        collection.remove(shape);
        assertTrue(collection.isEmpty());
    }

    @Test(dataProvider = "Collections")
    public void testContains(Collection<Shape> collection) {
        Shape shape = newShape();

        assertFalse(collection.contains(shape));
        collection.add(shape);
        assertTrue(collection.contains(shape));
        collection.remove(shape);
        assertFalse(collection.contains(shape));
    }

    @Test(dataProvider = "collections")
    public void testIterator(Collection<Shape> collection) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();
        collection.add(shape1);
        collection.add(shape2);

        Collection<Shape> shapes = new LinkedList<>();

        for (Shape shape : collection)
            shapes.add(shape);

        assertTrue(shapes.containsAll(collection));
        assertEquals(shapes.size(), 2);

        Iterator<Shape> iterator = collection.iterator();

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test(dataProvider = "Collections")
    public void testToArray(Collection<Shape> collection) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();
        collection.add(shape1);
        collection.add(shape2);
        Object[] array = collection.toArray();
        Shape[] shapes = new Shape[2];
        collection.toArray(shapes);

        assertTrue(collection.containsAll(Arrays.asList(array)));
        assertTrue(collection.containsAll(Arrays.asList(shapes)));
        assertTrue(Arrays.asList(array).containsAll(collection));
        assertTrue(Arrays.asList(shapes).containsAll(collection));
    }

    @Test(dataProvider = "Collections")
    public void testAdd(Collection<Shape> collection) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();


        assertTrue(collection.isEmpty());
        assertTrue(collection.add(shape2));
        assertEquals(collection.size(), 1);
        collection.add(shape1);
        assertEquals(collection.size(), 2);
        assertTrue(collection.contains(shape1));
        assertTrue(collection.contains(shape2));
    }

    @Test(dataProvider = "Collections")
    public void testRemove(Collection<Shape> collection) {
        Shape shape = newShape();
        collection.add(shape);
        collection.remove(shape);
        collection.add(shape);
        collection.remove(shape);

        assertEquals(collection.size(), 0);
        assertFalse(collection.contains(shape));
        assertTrue(collection.isEmpty());
    }

    @Test(dataProvider = "Collections")
    public void testContainsAll(Collection<Shape> collection) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();
        collection.add(shape1);
        collection.add(shape2);
        collection.add(newShape());

        Collection<Shape> arrayCollection = new ArrayList<>();
        arrayCollection.add(shape1);
        arrayCollection.add(shape2);

        assertTrue(collection.containsAll(arrayCollection));
        arrayCollection.add(newShape());
        assertFalse(collection.containsAll(arrayCollection));
    }

    @Test(dataProvider = "Collections")
    public void testAddAll(Collection<Shape> collection) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();
        Shape shape3 = newShape();


        Collection<Shape> arrayCollection = new ArrayList<>();
        arrayCollection.add(shape1);
        arrayCollection.add(shape2);

        collection.add(shape3);
        collection.addAll(arrayCollection);

        assertTrue(collection.containsAll(arrayCollection));
        assertTrue(collection.contains(shape3));
    }

    @Test(dataProvider = "Collections")
    public void testRemoveAll(Collection<Shape> collection) {
        Collection<Shape> arrayCollection = new ArrayList<>();
        arrayCollection.add(newShape());
        arrayCollection.add(newShape());

        collection.addAll(arrayCollection);
        collection.removeAll(arrayCollection);

        assertTrue(collection.isEmpty());
    }

    @Test(dataProvider = "Collections")
    public void testRetainAll(Collection<Shape> collection) {
        Shape shape1 = newShape();
        Shape shape2 = newShape();
        Shape shape3 = newShape();

        collection.add(shape1);
        collection.add(shape3);

        Collection<Shape> arrayCollection = new ArrayList<>();
        arrayCollection.add(shape1);
        arrayCollection.add(shape2);

        collection.retainAll(arrayCollection);

        assertEquals(collection.size(), 1);
        assertTrue(collection.contains(shape1));
    }

    @Test(dataProvider = "Collections")
    public void testClear(Collection<Shape> collection) {
        collection.add(newShape());
        collection.add(newShape());
        collection.clear();

        assertTrue(collection.isEmpty());
    }

}
