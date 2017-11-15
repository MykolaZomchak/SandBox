package patterns.structural.factory;

public enum ShapeSizes {
    SMALL(1),
    MEDIUM(2),
    BIG(3);

    private int toInt;

    ShapeSizes(int toInt){
        this.toInt = toInt;
    }
    public int toInt(){
        return toInt;
    }
}
