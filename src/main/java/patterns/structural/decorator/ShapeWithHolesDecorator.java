package patterns.structural.decorator;

import shapes.Shape;

public class ShapeWithHolesDecorator extends ShapeDecorator{

    private double holesArea;

    public ShapeWithHolesDecorator(Shape shape, double holesArea) {
        super(shape);
        this.holesArea = holesArea;
    }

    @Override
    public double getArea() {
        return super.getArea() - holesArea;
    }
}
