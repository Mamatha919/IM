import java.util.HashMap;
import java.util.Scanner;

public class IM {
    private static HashMap<String, Integer> inventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add a product");
            System.out.println("2. View inventory");
            System.out.println("3. View low stock items");
            System.out.println("4. Search product by name");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    displayInventory();
                    break;
                case "3":
                    displayLowStockItems();
                    break;
                case "4":
                    searchProductByName();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter quantity: ");
        try {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity < 0) {
                System.out.println("Quantity cannot be negative.");
                return;
            }
            inventory.put(productName, inventory.getOrDefault(productName, 0) + quantity);
            System.out.println("Product added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number for quantity.");
        }
    }

    private static void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (String product : inventory.keySet()) {
                System.out.println(product + ": " + inventory.get(product));
            }
        }
    }

    private static void displayLowStockItems() {
        System.out.println("\nLow Stock Items (less than 35):");
        boolean hasLowStock = false;
        for (String product : inventory.keySet()) {
            int qty = inventory.get(product);
            if (qty < 35) {
                System.out.println(product + ": " + qty);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("No items are below 35 in stock.");
        }
    }

    private static void searchProductByName() {
        System.out.print("Enter product name to search: ");
        String productName = scanner.nextLine();
        if (inventory.containsKey(productName)) {
            System.out.println(productName + ": " + inventory.get(productName));
        } else {
            System.out.println("Product not found in inventory.");
        }
    }
}