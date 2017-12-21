package patterns.creational.singleton;

public class Counter {

    private int counter;
    private static Counter instance;

    private Counter(){};

    public static Counter getInstance(){
        if(instance==null)
            instance = new Counter();
        return instance;
    }

    public int increment(){
        return counter++;
    }

}
