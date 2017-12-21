package patterns.creational.builder;

import patterns.creational.prototype.Square;
import shapes.Circle;
import shapes.Triangle;

public class SimpleDrawingBuilder implements DrawingBuilder{

    Drawing drawing = new Drawing();

    @Override
    public void buildTriangle() {
        drawing.setTriangle(new Triangle("triangle", 1, 1, 1));
    }

    @Override
    public void buildCircle() {
        drawing.setCircle(new Circle("circle", 1));
    }

    @Override
    public void buildSquare() {
        drawing.setSquare(new Square("square", 1));
    }

    @Override
    public Drawing getResult() {
        return drawing;
    }
}
