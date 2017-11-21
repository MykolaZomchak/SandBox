package patterns.structural.flyweight_factory;

import shapes.Colors;
import shapes.Shape;
import shapes.Shapes;

public class FlyweightFactoryShowDown {

    private static final Colors colors[] = {Colors.BLUE, Colors.GREEN, Colors.RED};

    public static void main(String[] args) {

        ShapeFactory factory = new FlyweightShapeFactory();

        for (int i = 0; i < 20; ++i) {
            Shape shape = factory.createShape(Shapes.CIRCLE, getRandomColor());
            shape.draw();
        }
    }

    private static Colors getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

}
