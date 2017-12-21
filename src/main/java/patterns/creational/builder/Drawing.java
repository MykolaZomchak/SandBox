package patterns.creational.builder;

import patterns.creational.prototype.Square;
import shapes.Circle;
import shapes.Triangle;

public class Drawing {

    private Triangle triangle;
    private Circle circle;
    private Square square;

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
