package patterns.structural.adapter.ports;

import patterns.structural.adapter.datatypes.LightningData;

public interface Lightning{
    void receiveData(LightningData data);
}
