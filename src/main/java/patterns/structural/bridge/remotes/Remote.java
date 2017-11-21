package patterns.structural.bridge.remotes;

import patterns.structural.bridge.devices.Device;

public interface Remote {

    void buttonOnePressed();

    void buttonTwoPressed();

    void buttonThreePressed();

    void buttonFourPressed();

    void buttonFivePressed();

    void setDevice(Device newDevice);

}
