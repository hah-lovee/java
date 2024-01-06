public class GraphicsDrawingTablet extends GraphicsTablet {
    private int sensitivity;

    
    public GraphicsDrawingTablet(String name, String brand, double price, String tabletSize, int sensitivity) {
        super(name, brand, price, tabletSize);
        this.sensitivity = sensitivity;

    }

    @Override
    public String getDescription() {
        return name + " (Size: " + tabletSize + ") by " + brand + "with sensitivity:" + sensitivity;
    }

    public void forRedefinition() {
        System.out.println("я переопределенный");
    }
}
