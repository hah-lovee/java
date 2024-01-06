package first_block.laba7;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class Quest2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 9, 6},
                {7, 8, 5}
        };

        int numThreads = 2;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int rowsPerThread = matrix.length / numThreads;
        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            final int startRow = i * rowsPerThread;
            final int endRow = (i == numThreads - 1) ? matrix.length : (i + 1) * rowsPerThread;

            Callable<Integer> task = () -> {
                int maxInThread = matrix[startRow][0];
                for (int row = startRow; row < endRow; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col] > maxInThread) {
                            maxInThread = matrix[row][col];
                        }
                    }
                }
                return maxInThread;
            };

            tasks.add(task);
        }

        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);

            int globalMax = Integer.MIN_VALUE;
            for (Future<Integer> future : futures) {
                int threadMax = future.get();
                if (threadMax > globalMax) {
                    globalMax = threadMax;
                }
            }

            System.out.println("Global max element: " + globalMax);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
