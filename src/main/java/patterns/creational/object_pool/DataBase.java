package patterns.creational.object_pool;

public class DataBase {

    private int connections;
    private int idCounter = 0;
    private static DataBase instance;

    private DataBase() {
    }

    public static synchronized DataBase getInstance() {
        if (instance == null)
            instance = new DataBase();
        return instance;
    }

    public synchronized int openConnection() {
        if (connections >= 40)
            return -1;
        idCounter++;
        connections++;
        System.out.print(connections + " ");
        try {
            Thread.sleep((int) (Math.random() * 50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return idCounter;
    }

    public synchronized void closeConnection() {
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        connections--;
        System.out.print(connections + " ");

    }
}
