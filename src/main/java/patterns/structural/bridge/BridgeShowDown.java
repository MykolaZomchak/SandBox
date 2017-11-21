package patterns.structural.bridge;

import patterns.structural.bridge.devices.Device;
import patterns.structural.bridge.devices.DvdDevice;
import patterns.structural.bridge.devices.TVDevice;
import patterns.structural.bridge.remotes.ExplodeControl;
import patterns.structural.bridge.remotes.MuteControl;
import patterns.structural.bridge.remotes.Remote;

public class BridgeShowDown {

    public static void main(String[] args) {

        Device tv = new TVDevice();
        Device dvd = new DvdDevice();

        Remote explodeRemote = new ExplodeControl(tv);
        Remote muteRemote = new MuteControl(tv);

        muteRemote.buttonFivePressed(); //Device muted
        muteRemote.buttonTwoPressed(); // Switch to 0 channel

        muteRemote.setDevice(dvd);
        muteRemote.buttonTwoPressed(); // Playing from 0 minute

        explodeRemote.buttonFivePressed(); // small boom

        explodeRemote.setDevice(dvd);
        explodeRemote.buttonFivePressed(); // BIG BOOM!!!
    }

}
