package patterns.structural.bridge.devices;

public class TVDevice extends BaseDevice {

    private int channel;

    public int getChannel() {
        return channel;
    }

    @Override
    public void buttonOnePressed() {
        channel++;
    }

    @Override
    public void buttonTwoPressed() {
        if (channel > 0)
            channel--;
    }

    @Override
    public void explode() {
        System.out.println("small boom");
    }
}
