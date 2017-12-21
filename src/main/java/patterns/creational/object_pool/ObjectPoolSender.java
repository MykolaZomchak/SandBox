package patterns.creational.object_pool;

public class ObjectPoolSender extends Thread implements Sender {
    @Override
    public void sendSomeInfo() {
        start();
    }

    @Override
    public void run() {
        DBConnection connection = DBConnectionPool.getConnection();
        while(connection==null){
            Thread.yield();
            connection = DBConnectionPool.getConnection();
        }
        try {
            Thread.sleep((int) (Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DBConnectionPool.releaseConnection(connection);

    }

}
