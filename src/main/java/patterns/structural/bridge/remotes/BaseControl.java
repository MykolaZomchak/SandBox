package patterns.structural.bridge.remotes;

import patterns.structural.bridge.devices.Device;

public abstract class BaseControl implements Remote {

    protected Device device;

    public BaseControl(Device device) {
        this.device = device;
    }

    @Override
    public void buttonOnePressed() {
        device.buttonOnePressed();
    }

    @Override
    public void buttonTwoPressed() {
        device.buttonTwoPressed();
    }

    @Override
    public void buttonThreePressed() {
        device.buttonThreePressed();
    }

    @Override
    public void buttonFourPressed() {
        device.buttonFourPressed();
    }

    @Override
    public void setDevice(Device newDevice) {
        device = newDevice;
    }
}
