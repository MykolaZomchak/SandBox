package shapes;

public enum Colors {

    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    NO_COLOR("\u001B[0m");

    private String ansiCode;

    Colors(String ansiCode){
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return ansiCode;
    }
}
