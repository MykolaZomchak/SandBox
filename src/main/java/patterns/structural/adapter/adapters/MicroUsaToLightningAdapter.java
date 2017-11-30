package patterns.structural.adapter.adapters;

import patterns.structural.adapter.datatypes.LightningData;
import patterns.structural.adapter.datatypes.UsbData;
import patterns.structural.adapter.ports.Lightning;
import patterns.structural.adapter.ports.MicroUsb;

public class MicroUsaToLightningAdapter implements MicroUsb {

    private Lightning device;

    public MicroUsaToLightningAdapter(Lightning device) {
        this.device = device;
    }

    @Override
    public void receiveData(UsbData data) {
        device.receiveData(convert(data));
    }

    private LightningData convert(UsbData data){
        return new LightningData();
    }
}
