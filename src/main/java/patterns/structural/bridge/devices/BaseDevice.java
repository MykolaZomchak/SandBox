package patterns.structural.bridge.devices;

public abstract class BaseDevice implements Device {

    private int volumeLevel = 0;

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void mute(){
        volumeLevel = 0;
    }

    @Override
    public void buttonThreePressed() {
        if(volumeLevel<=100)
            volumeLevel++;
    }

    @Override
    public void buttonFourPressed() {
        if(volumeLevel>0)
            volumeLevel--;
    }
}
