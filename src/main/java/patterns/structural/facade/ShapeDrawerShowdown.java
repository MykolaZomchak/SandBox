package patterns.structural.facade;

import shapes.Colors;

public class ShapeDrawerShowdown {

    public static void main(String[] args){

        ShapeDrawer drawer = new CircleDrawer();
        drawer.draw(3, Colors.BLUE);
        drawer.draw(Colors.RED);
        System.out.println("\nTraffic lights:");
        drawer.drawTrafficLights();
    }

}
