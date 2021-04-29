package amit.examples.stuff;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentIncrementExample {

    private int primitiveCounter = 0;
    private volatile int volatileCounter = 0;
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    //Thread unsafe | incorrect but fast :)
    public void addToPrimitive(int add) {
        primitiveCounter += add;
    }

    //Thread unsafe | non-atomic operation on a volatile field
    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public void addToVolatile(int add) {
        volatileCounter += add;
    }

    //Thread-safe | best
    public void addToAtomic(int add) {
        atomicInteger.addAndGet(add);
    }

    public static void main(String[] args) {

        //Single ThreadedExecutionTest.
        ConcurrentIncrementExample c = new ConcurrentIncrementExample();
        //Warmup hotspot
        int count = 1_000_000_000;
        for (int i = 0; i < count; i++) {
            c.addToPrimitive(1);
        }

        for (int i = 0; i < count; i++) {
            c.addToVolatile(1);
        }

        for (int i = 0; i < count; i++) {
            c.addToAtomic(1);
        }
        for (int i = 0; i < count; i++) {
            c.primitiveCounter++;
        }
        for (int i = 0; i < count; i++) {
            //noinspection NonAtomicOperationOnVolatileField
            c.volatileCounter++;
        }
        for (int i = 0; i < count; i++) {
            c.atomicInteger.incrementAndGet();
        }
        //Warmup End;

        c = new ConcurrentIncrementExample();
        long nanoStart = System.nanoTime();
        for (int i = 0; i < count; i++) {
            c.addToPrimitive(1);
        }
        System.out.println("Primitive: " + (System.nanoTime() - nanoStart) / 1_000_000.0);
        nanoStart = System.nanoTime();
        for (int i = 0; i < count; i++) {
            c.addToVolatile(1);
        }
        System.out.println("Volatile: " + (System.nanoTime() - nanoStart) / 1_000_000.0);
        nanoStart = System.nanoTime();
        for (int i = 0; i < count; i++) {
            c.addToAtomic(1);
        }
        System.out.println("Atomic: " + (System.nanoTime() - nanoStart) / 1_000_000.0);

        c = new ConcurrentIncrementExample();
        nanoStart = System.nanoTime();
        for (int i = 0; i < count; i++) {
            c.primitiveCounter++;
        }
        System.out.println("Primitive without method call: " + (System.nanoTime() - nanoStart) / 1_000_000.0);
        nanoStart = System.nanoTime();
        for (int i = 0; i < count; i++) {
            //noinspection NonAtomicOperationOnVolatileField
            c.volatileCounter++;
        }
        System.out.println("Volatile without method call:: " + (System.nanoTime() - nanoStart) / 1_000_000.0);
        nanoStart = System.nanoTime();
        for (int i = 0; i < count; i++) {
            c.atomicInteger.incrementAndGet();
        }
        System.out.println("Atomic without method call:: " + (System.nanoTime() - nanoStart) / 1_000_000.0);
    }

    /*
Run 1 *
Sample Results on my old laptop
Primitive: 70.5167
Volatile: 6454.5862
Atomic: 6623.8601

Run 2 *
Primitive: 55.5333
Volatile: 6339.3108
Atomic: 6359.0413

Run 3 *
Primitive: 55.0597
Volatile: 6363.1702
Atomic: 6534.2201
Primitive without method call: 55.9118
Volatile without method call:: 6354.6075
Atomic without method call:: 6474.0924
     */
}
