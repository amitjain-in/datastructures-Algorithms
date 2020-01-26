package amit.examples.stuff;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentIncrementExample {

    private int primitiveCounter = 0;
    private volatile int volatileCounter = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //Thread unsafe | incorrect but fast :)
    public void addToPrimitive(int add) {
        primitiveCounter += add;
    }

    //Thread unsafe | non-atomic operation on a volatile field
    public void addToVolatile(int add) {
        volatileCounter += add;
    }

    //Thread-safe | best
    public void addToAtomic(int add) {
        atomicInteger.addAndGet(add);
    }
}
