package first_block.laba7.Quest3;

class Goods {
    private String name;
    private int weight;

    public Goods(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
