package amit.examples.stuff;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IntellijAssistExample {

    public final Map<String, Integer> hashMap = new ConcurrentHashMap<>();

    public void incrementCounter(String k) {
        hashMap.merge(k, 1, Integer::sum);
    }
}
