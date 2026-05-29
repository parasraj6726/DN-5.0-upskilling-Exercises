// Q41: Executor Service and Callable
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallable {

    // A Callable task that computes the square of a number
    static class SquareTask implements Callable<Integer> {
        private int number;

        SquareTask(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(100); // simulate work
            int result = number * number;
            System.out.println(Thread.currentThread().getName()
                    + " computed " + number + "^2 = " + result);
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        int poolSize = 4;
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        List<Future<Integer>> futures = new ArrayList<>();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

        // Submit all tasks
        for (int n : numbers) {
            futures.add(executor.submit(new SquareTask(n)));
        }

        // Collect results
        System.out.println("\nResults:");
        for (int i = 0; i < numbers.length; i++) {
            int result = futures.get(i).get(); // blocks until result is ready
            System.out.println("Square of " + numbers[i] + " = " + result);
        }

        executor.shutdown();
        System.out.println("\nAll tasks completed.");
    }
}
