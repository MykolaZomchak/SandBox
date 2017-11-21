package patterns.structural.bridge.devices;

public class DvdDevice extends BaseDevice {

    private int filmTime;

    public int getFilmTime() {
        return filmTime;
    }

    @Override
    public void buttonOnePressed() {
        filmTime++;
    }

    @Override
    public void buttonTwoPressed() {
        if (filmTime > 0)
            filmTime--;
        System.out.println("Playing from " + filmTime + " minute");
    }

    @Override
    public void explode() {
        System.out.println("BIG BOOM!!!");
    }
}
