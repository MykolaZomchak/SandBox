package patterns.creational.object_pool;

public class SimpleSender extends Thread implements Sender {
    @Override
    public void sendSomeInfo() {
        start();
    }

    @Override
    public void run(){
        DBConnection connection = new DBConnection();
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        connection.close();
    }
}
