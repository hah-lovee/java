public class Keyboard extends ComputerPeripheral {
    private String layout;

    public Keyboard(String name, String brand, double price, String layout) {
        super(name, brand, price);
        this.layout = layout;
    }

    public Keyboard() {
        this ("Unknown", "Unknown", 0.0, "QWERTY");
    }

    @Override
    public String getDescription() {
        return name + " (" + layout + " layout) by " + brand;
    }

    @Override
    public void connect() {
        System.out.println("Connect via USB or Bluetooth");
    }
}
