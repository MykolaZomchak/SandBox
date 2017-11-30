package patterns.structural.decorator;

import shapes.Shape;

public class ShapeWithHoles extends ShapeDecorator{

    private double holesArea;

    public ShapeWithHoles(Shape shape, double holesArea) {
        super(shape);
        this.holesArea = holesArea;
    }

    @Override
    public void draw() {
        System.out.print("(Area of holes: " + holesArea + ") ");
        super.draw();
    }

    @Override
    public double getArea() {
        return super.getArea() - holesArea;
    }
}
