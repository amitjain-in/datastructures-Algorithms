package amit.examples.stuff;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapExample {

    public final Map<String, String>  hashMap = new HashMap<>();
    public final Map<String, String> safeMap = new ConcurrentHashMap<>();

    //Not thread-safe
    public void addToMap(String k, String v) {
        hashMap.put(k, v);
    }

    //thread-safe
    public void addToSafeMap(String k, String v) {
        safeMap.put(k, v);
    }
}
