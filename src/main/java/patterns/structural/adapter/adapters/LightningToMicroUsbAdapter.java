package patterns.structural.adapter.adapters;

import patterns.structural.adapter.datatypes.LightningData;
import patterns.structural.adapter.datatypes.UsbData;
import patterns.structural.adapter.ports.Lightning;
import patterns.structural.adapter.ports.MicroUsb;

public class LightningToMicroUsbAdapter implements Lightning {

    private MicroUsb device;

    public LightningToMicroUsbAdapter(MicroUsb device) {
        this.device = device;
    }

    @Override
    public void receiveData(LightningData data) {
        device.receiveData(convert(data));
    }

    private UsbData convert(LightningData data){
        return new UsbData();
    }


}
