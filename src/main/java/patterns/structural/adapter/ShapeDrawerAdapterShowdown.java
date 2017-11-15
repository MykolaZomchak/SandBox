package patterns.structural.adapter;

public class ShapeDrawerAdapterShowdown {

    public static void main(String[] args){

        ShapeDrawerAdapter adapter = new ShapeDrawerAdapterImpl();

        adapter.drawRandomShapes();

        System.out.print("\n");

        System.out.println("TrafficLights:");
        adapter.drawTrafficLights();

    }
}
