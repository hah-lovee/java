public abstract class ComputerPeripheral {
    protected String name;
    protected String brand;
    protected double price;

    public ComputerPeripheral(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public abstract String getDescription();
    public abstract void connect();

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
