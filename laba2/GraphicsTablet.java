public class GraphicsTablet extends ComputerPeripheral {
    protected String tabletSize;
    private static int numCreated = 0;

    public GraphicsTablet(String name, String brand, double price, String tabletSize) {
        super(name, brand, price);
        this.tabletSize = tabletSize;
        numCreated++;
    }

    @Override
    public String getDescription() {
        return name + " (Size: " + tabletSize + ") by " + brand;
    }


    @Override
    public void connect() {
        System.out.println("Connect via USB or wireless receiver");
    }

    public static int getNumCreated() {
        return numCreated;
    }

    public void forRedefinition() {
        System.out.println("я не переопределенный");
    }
}