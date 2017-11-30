package patterns.structural.facade;

import shapes.Colors;

/**
 * Simplifies shape drawing, handles all work with creating instances and working with decorators
 */
public interface ShapeDrawer {

    void draw();

    void draw(int count);

    void draw(Colors color);

    void draw(int count, Colors color);

    void drawTrafficLights();

}
