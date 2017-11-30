package patterns.structural.adapter.phones;

import patterns.structural.adapter.datatypes.LightningData;
import patterns.structural.adapter.ports.Lightning;

public class IPhone extends Phone implements Lightning {

    @Override
    public void receiveData(LightningData data) {
        this.data = data.toString();
        super.receiveData();
    }

    @Override
    public String toString() {
        return "IPhone";
    }
}
