package searchInventory;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        Scanner scanner = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");

        for(int i = 0;i < inventory.size();i++) {
            Product item = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f", item.getId(),item.getName(),item.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(1,"gameBoy",50.00f));
        inventory.add(new Product(2,"psp",150.00f));
        inventory.add(new Product(3,"atari",100.00f));
        inventory.add(new Product(4,"legos", 12.50f));
        inventory.add(new Product(5,"chicken",50.00f));

        return inventory;
    }
}
