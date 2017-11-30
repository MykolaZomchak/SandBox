package patterns.structural.adapter.phones;

public abstract class Phone {

    String data;

    protected void receiveData(){
        System.out.println(this + " received some data");
    }

}
