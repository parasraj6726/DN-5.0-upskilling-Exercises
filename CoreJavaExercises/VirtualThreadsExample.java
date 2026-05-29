// Q40: Virtual Threads (Java 21)
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100_000;
        AtomicInteger counter = new AtomicInteger(0);

        // --- Virtual Threads ---
        long startVirtual = System.currentTimeMillis();

        Thread[] virtualThreads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            virtualThreads[i] = Thread.ofVirtual().start(() -> {
                counter.incrementAndGet();
                // Simulate brief work
            });
        }
        for (Thread t : virtualThreads) t.join();

        long virtualTime = System.currentTimeMillis() - startVirtual;
        System.out.println("Virtual threads  : " + threadCount + " threads in " + virtualTime + " ms");
        System.out.println("Counter value    : " + counter.get());

        // --- Platform (Traditional) Threads for comparison (use fewer to avoid OOM) ---
        int platformCount = 1000;
        counter.set(0);
        long startPlatform = System.currentTimeMillis();

        Thread[] platformThreads = new Thread[platformCount];
        for (int i = 0; i < platformCount; i++) {
            platformThreads[i] = Thread.ofPlatform().start(() -> counter.incrementAndGet());
        }
        for (Thread t : platformThreads) t.join();

        long platformTime = System.currentTimeMillis() - startPlatform;
        System.out.println("\nPlatform threads : " + platformCount + " threads in " + platformTime + " ms");
        System.out.println("Counter value    : " + counter.get());

        System.out.println("\nVirtual threads are far more scalable for I/O-bound workloads!");
    }
}
