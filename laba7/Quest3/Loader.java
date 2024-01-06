package first_block.laba7.Quest3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Loader implements Callable<Void> {
    private String name;
    private Warehouse sourceWarehouse;
    private Warehouse destinationWarehouse;

    public Loader(String name, Warehouse sourceWarehouse, Warehouse destinationWarehouse) {
        this.name = name;
        this.sourceWarehouse = sourceWarehouse;
        this.destinationWarehouse = destinationWarehouse;
    }

    @Override
    public Void call() throws Exception {
        int totalWeight = 0;
        List<Goods> goodsToMove = new ArrayList<>();

        while (totalWeight < 150) {
            Goods goods = sourceWarehouse.getGoods();
            if (goods != null) {

                goodsToMove.add(goods);
                
                totalWeight += goods.getWeight();
            } else {
                break;
            }
        }

        if (!goodsToMove.isEmpty()) {
            System.out.println(name + " is moving goods: " + goodsToMove + " (Total Weight: " + totalWeight + "kg)");
            System.out.println(name + " has moved goods to the destination warehouse.");
            destinationWarehouse.getGoods(); 
        }

        return null;
    }
}