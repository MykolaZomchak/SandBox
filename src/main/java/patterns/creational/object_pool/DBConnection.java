package patterns.creational.object_pool;

import java.util.Objects;

public class DBConnection {

    private int id;

    public DBConnection(){
        open();
    }

    public void open(){

        id = DataBase.getInstance().openConnection();

        while(id == -1){
            Thread.yield();
            id = DataBase.getInstance().openConnection();
        }
    }

    public void close(){
        DataBase.getInstance().closeConnection();
    }

    public void send(String info){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBConnection that = (DBConnection) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
