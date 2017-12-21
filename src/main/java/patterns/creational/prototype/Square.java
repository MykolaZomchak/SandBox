package patterns.creational.prototype;

import shapes.BaseShape;

public class Square extends BaseShape {


    private Square(String description){
        super(description);
    }

    public Square(String description, double side) {
        this(description);
        perimeter = side*4;
        area = side*side;
    }

    public Square getCopy(){
        Square copy = new Square(description);
        copy.perimeter = perimeter;
        copy.area = area;
        return copy;
    }

}
