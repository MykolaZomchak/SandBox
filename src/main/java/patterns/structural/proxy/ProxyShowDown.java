package patterns.structural.proxy;

public class ProxyShowDown {

    public static void main(String[] args) {
        Image image = new ProxyImage("testImage");
        System.out.println("Created proxy");
        System.out.println("Some text before displaying the image");
        image.display();
        System.out.print("\n");

        image.display();
    }

}
