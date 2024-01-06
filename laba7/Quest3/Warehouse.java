package first_block.laba7.Quest3;

import java.util.List;

class Warehouse {
    private List<Goods> goodsList;

    public Warehouse(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public synchronized Goods getGoods() {
        if (!goodsList.isEmpty()) {
            return goodsList.remove(0);
        }
        return null;
    }
}