package patterns.structural.adapter.phones;

import patterns.structural.adapter.datatypes.UsbData;
import patterns.structural.adapter.ports.MicroUsb;

public class Samsung extends Phone implements MicroUsb {

    @Override
    public void receiveData(UsbData data) {
        this.data = data.toString();
    }

    @Override
    public String toString() {
        return "Samsung" + super.toString();
    }
}
