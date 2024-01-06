package first_block.laba7;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;


public class Quest1 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int numThreads = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int chunkSize = data.length / numThreads;
        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = (i == numThreads - 1) ? data.length : (i + 1) * chunkSize;

            Callable<Integer> task = () -> {
                int sum = 0;
                for (int j = start; j < end; j++) {
                    sum += data[j];
                }
                return sum;
            };

            tasks.add(task);
        }

        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);

            int totalSum = 0;
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            }

            System.out.println("Total sum: " + totalSum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
