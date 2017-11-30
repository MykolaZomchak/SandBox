package patterns.structural.adapter.ports;

import patterns.structural.adapter.datatypes.UsbData;

public interface MicroUsb {
    void receiveData(UsbData data);
}
