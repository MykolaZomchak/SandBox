package patterns.structural.adapter;

import patterns.structural.facade.CircleDrawer;
import patterns.structural.facade.ShapeDrawer;
import patterns.structural.facade.TriangleDrawer;
import shapes.Colors;

import static shapes.Colors.GREEN;
import static shapes.Colors.YELLOW;

public class SimpleShapeDrawerAdapter implements ShapeDrawerAdapter {

    ShapeDrawer circleDrawer = new CircleDrawer();
    ShapeDrawer triangleDrawer = new TriangleDrawer();

    @Override
    public void drawRandomShapes() {
        circleDrawer.draw(GREEN);
        triangleDrawer.draw();
        circleDrawer.draw(2, YELLOW);
        triangleDrawer.draw(Colors.BLUE);
    }

    @Override
    public void drawTrafficLights() {
        circleDrawer.draw(GREEN);
        circleDrawer.draw(Colors.YELLOW);
        circleDrawer.draw(Colors.RED);
    }

}
