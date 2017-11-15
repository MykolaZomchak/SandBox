package shapes;

public enum Colors {

    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m");

    private String ansiCode;

    private Colors(String ansiCode){
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return ansiCode;
    }
}
