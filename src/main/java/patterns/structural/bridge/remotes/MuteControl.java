package patterns.structural.bridge.remotes;

import patterns.structural.bridge.devices.Device;

public class MuteControl extends BaseControl {
    public MuteControl(Device device) {
        super(device);
    }

    @Override
    public void buttonFivePressed() {
        device.mute();
    }
}
