package first_block.laba6.Quest3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SalesManagementSystem salesManagementSystem = new SalesManagementSystem();

        Product product1 = new Product("Product1", 10.0);
        Product product2 = new Product("Product2", 15.0);

        System.out.println("Enter quantity for Product1:");
        int quantity1 = scanner.nextInt();
        salesManagementSystem.addSale(product1, quantity1);

        System.out.println("Enter quantity for Product2:");
        int quantity2 = scanner.nextInt();
        salesManagementSystem.addSale(product2, quantity2);

        salesManagementSystem.displaySales();
        // сверху накидываем еще товара второго вида
        salesManagementSystem.addSale(product2, 12);

        System.out.println();
        // смотрим, чем отличается вывод
        salesManagementSystem.displaySales();

        System.out.println("Total Sales: $" + salesManagementSystem.calculateTotalSales());

        System.out.println("Most Popular Product: " + salesManagementSystem.findMostPopularProduct());
    }
}
