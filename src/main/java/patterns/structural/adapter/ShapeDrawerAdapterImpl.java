package patterns.structural.adapter;

import patterns.structural.facade.CircleDrawer;
import patterns.structural.facade.ShapeDrawer;
import patterns.structural.facade.TriangleDrawer;
import shapes.Colors;

import static shapes.Colors.*;

public class ShapeDrawerAdapterImpl implements ShapeDrawerAdapter {

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

    @Override
    public void drawColorfulTriangles() {
        triangleDrawer.draw(GREEN);
        triangleDrawer.draw(Colors.YELLOW);
        triangleDrawer.draw(Colors.RED);
    }
}
