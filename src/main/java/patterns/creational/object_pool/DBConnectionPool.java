package patterns.creational.object_pool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DBConnectionPool {
    private static final int MAX_IN_USE = 15;
    private static HashMap<DBConnection, Long> available = new HashMap<>();
    private static HashMap<DBConnection, Long> inUse = new HashMap<>();


    public synchronized static DBConnection getConnection() {
        long now = System.currentTimeMillis();
        if (!available.isEmpty()) {
            Iterator<Map.Entry<DBConnection, Long>> iterator = available.entrySet().iterator();
            Map.Entry<DBConnection, Long> entry = iterator.next();
            iterator.remove();
            DBConnection c = entry.getKey();
            push(inUse, c, now);
            return c;
        }
        if(inUse.entrySet().size() >= MAX_IN_USE)
            return null;
        return createDBConnection(now);
    }

    private synchronized static DBConnection createDBConnection(long now) {
        DBConnection c = new DBConnection();
        push(inUse, c, now);
        return c;
    }

    private synchronized static void push(HashMap<DBConnection, Long> map,
                                          DBConnection c, long now) {
        map.put(c, now);
    }

    public synchronized static void releaseConnection(DBConnection c) {
        available.put(c, System.currentTimeMillis());
        inUse.remove(c);
    }

    public synchronized static void cleanUp() {
        for (Map.Entry<DBConnection, Long> entry : available.entrySet())
                entry.getKey().close();
        available.clear();
    }

}
