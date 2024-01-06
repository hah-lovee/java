package first_block.laba6.Quest3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.HashMap;
import java.util.Map;

public class SalesManagementSystem {
    private List<Sale> sales;
    private Map<String, Integer> productSoldQuantity;

    public SalesManagementSystem() {
        this.sales = new CopyOnWriteArrayList<>();
        this.productSoldQuantity = new HashMap<>();
    }

    public void addSale(Product product, int quantity) {
        Sale sale = new Sale(product, quantity);
        sales.add(sale);

        productSoldQuantity.put(product.getName(),
                productSoldQuantity.getOrDefault(product.getName(), 0) + quantity);
    }

    public void displaySales() {
        System.out.println("List of Sales:");
        for (Sale sale : sales) {
            System.out.println(sale.getProduct().getName() + " - Quantity: " +
                    sale.getQuantity() + " - Total: $" + sale.getTotal());
        }
    }

    public double calculateTotalSales() {
        double totalSales = 0;
        for (Sale sale : sales) {
            totalSales += sale.getTotal();
        }
        return totalSales;
    }

    public String findMostPopularProduct() {
        String mostPopularProduct = null;
        int maxQuantity = 0;

        for (Map.Entry<String, Integer> entry : productSoldQuantity.entrySet()) {
            if (entry.getValue() > maxQuantity) {
                mostPopularProduct = entry.getKey();
                maxQuantity = entry.getValue();
            }
        }
        return mostPopularProduct + " - Quantity: " + Integer.toString(maxQuantity);
    }
}
