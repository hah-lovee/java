package first_block.laba7.Quest3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WarehouseTransfer {
    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Goods("Item1", 30));
        goodsList.add(new Goods("Item2", 40));
        goodsList.add(new Goods("Item3", 20));
        goodsList.add(new Goods("Item4", 60));
        goodsList.add(new Goods("Item5", 153));

        Warehouse sourceWarehouse = new Warehouse(goodsList);
        Warehouse destinationWarehouse = new Warehouse(new ArrayList<>());

        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < 3; i++) {
            completionService.submit(new Loader("Loader" + (i + 1), sourceWarehouse, destinationWarehouse));
        }

        try {
            for (int i = 0; i < 3; i++) {
                Future<Void> future = completionService.take();
                future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ((ExecutorService) executor).shutdown();
    }
}