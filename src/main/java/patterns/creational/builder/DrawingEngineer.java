package patterns.creational.builder;

public class DrawingEngineer {

    private DrawingBuilder builder = new SimpleDrawingBuilder();

    public Drawing makeDrawing(){
        builder.buildCircle();
        builder.buildSquare();
        builder.buildTriangle();
        return builder.getResult();
    }
}
