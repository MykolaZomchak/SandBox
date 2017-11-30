package patterns.structural.decorator;

import shapes.Colors;
import shapes.Shape;

public class ColoredShape extends ShapeDecorator {

    private Colors color;

    public ColoredShape(Shape shape, Colors color) {
        super(shape);
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.print(color);
        super.draw();
        System.out.print(Colors.NO_COLOR);
    }
}
