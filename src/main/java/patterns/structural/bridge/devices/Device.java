package patterns.structural.bridge.devices;

public interface Device {


    int getVolumeLevel();

    void buttonOnePressed();
    void buttonTwoPressed();
    void buttonThreePressed();
    void buttonFourPressed();
    void mute();
    void explode();

}
