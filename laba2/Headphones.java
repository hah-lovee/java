public class Headphones extends ComputerPeripheral {
    private boolean wireless;

    public Headphones(String name, String brand, double price, boolean wireless) {
        super(name, brand, price);
        this.wireless = wireless;
    }

    @Override
    public String getDescription() {
        String connectionType = wireless ? "wireless" : "wired";
        return name + " (" + connectionType + ") by " + brand;
    }

    @Override
    public void connect() {
        System.out.println(wireless ? "Connect wirelessly via Bluetooth" : "Connect via 3.5mm audio jack");
    }
}