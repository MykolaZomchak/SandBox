package patterns.structural.decorator;

import shapes.Shape;

public abstract class ShapeDecorator implements Shape{

    private Shape shape;

    public ShapeDecorator(Shape shape){
        this.shape = shape;
    }

    @Override
    public double getPerimeter() {
        return shape.getPerimeter();
    }

    @Override
    public double getArea() {
        return shape.getArea();
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
