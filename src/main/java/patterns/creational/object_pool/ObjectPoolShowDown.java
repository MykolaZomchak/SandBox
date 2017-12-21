package patterns.creational.object_pool;

import java.util.LinkedList;
import java.util.List;

public class ObjectPoolShowDown {

    private static final int N = 250;

    public static void main(String[] args) throws InterruptedException {

        List<SimpleSender> simpleSenders = new LinkedList<>();
        List<ObjectPoolSender> objectPoolSenders = new LinkedList<>();

        long time = System.currentTimeMillis();
        for(int i=0;i<N;i++){
            simpleSenders.add(new SimpleSender());
            simpleSenders.get(i).sendSomeInfo();
        }
        for(SimpleSender sender : simpleSenders)
            sender.join();

        System.out.println("\nWithout object pool: " + (System.currentTimeMillis() - time) + "ms");

        time = System.currentTimeMillis();

        for(int i=0;i<N;i++){
            objectPoolSenders.add(new ObjectPoolSender());
            objectPoolSenders.get(i).sendSomeInfo();
        }

        for(ObjectPoolSender sender : objectPoolSenders)
            sender.join();
        DBConnectionPool.cleanUp();
        System.out.println("\nWith object pool:    " + (System.currentTimeMillis() - time) + "ms");



    }

}
