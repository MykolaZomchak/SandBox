package patterns.creational.builder;

public interface DrawingBuilder {

    void buildTriangle();
    void buildCircle();
    void buildSquare();
    Drawing getResult();

}
