package patterns.structural.bridge.remotes;

import patterns.structural.bridge.devices.Device;

public class ExplodeControl extends BaseControl {
    public ExplodeControl(Device device) {
        super(device);
    }

    @Override
    public void buttonFivePressed() {
        device.explode();
    }
}
