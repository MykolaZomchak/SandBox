package patterns.structural.adapter;

import patterns.structural.adapter.adapters.MicroUsaToLightningAdapter;
import patterns.structural.adapter.datatypes.UsbData;
import patterns.structural.adapter.phones.IPhone;

public class AdapterShowDown {

    public static void main(String[] args){
        IPhone phone = new IPhone();

        UsbData data = new UsbData();

        MicroUsaToLightningAdapter adapter = new MicroUsaToLightningAdapter(phone);

        adapter.receiveData(data);
    }

}
