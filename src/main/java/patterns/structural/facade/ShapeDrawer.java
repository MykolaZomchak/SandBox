package patterns.structural.facade;

import shapes.Colors;

public interface ShapeDrawer {

    public void draw();

    public void draw(int count);

    public void draw(Colors color);

    public void draw(int count, Colors color);

}
