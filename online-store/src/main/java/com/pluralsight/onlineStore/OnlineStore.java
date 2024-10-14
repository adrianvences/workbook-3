package com.pluralsight.onlineStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    static Scanner inputScanner = new Scanner(System.in);
    static ArrayList<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        storeHomeScreen();
        ArrayList<Product> products = productListMethod();

    }




    public static void storeHomeScreen() {
        String homeScreenPrompt = """
                ~Enter one of the options below to Navigate Menu~
                - 'a' to Display Products
                - 'b' to Display Cart
                - 'x' to Exit
                """;
        String displayCartPrompt = """
                ~ Enter one of the options below to Navigate Menu~
                - 'a' to Check Out
                - 'b' to remove Product from car
                - 'x' to go back to home screen
                """;



        while(true) {
            System.out.println("              *Online Store Menu*");
            String userInput = promptMaker(homeScreenPrompt);
            switch (userInput.toLowerCase()) {
                case "a":
                    ArrayList<Product> products = productListMethod();
                    printArrayMethods(products);
                    String input ;
                    while(true) {
                        input = promptMaker("Search for item or Enter 'x' to return to main screen.");
                        if (input.equalsIgnoreCase("x")) {
                            break;
                        }
                        Product foundProduct = searchProductByName(products, input);
                        if(foundProduct != null) {
                            System.out.println("Found product: " + foundProduct);
                            String addToCartInput = promptMaker("Do you want to add this to cart? Enter 'y' for yes or 'x' for no: ");
                            if(addToCartInput.equalsIgnoreCase("x")){
                                break;
                            }
                            if(addToCartInput.equalsIgnoreCase("y")){
                                addToCart(cart, foundProduct);
                            }
                        } else {
                            System.out.println("Product not found: " + input);
                        }
                    }



                break;
                case "b":
                    displayCart();
                    String displayCartInput;
                    while(true){
                        displayCartInput = promptMaker(displayCartPrompt);
                        if(displayCartInput.equalsIgnoreCase("a")) {
                            System.out.println("check out method");
                            break;
                        }
                        else if(displayCartInput.equalsIgnoreCase("b")) {
                            String removeProductInput = promptMaker("Enter product name to remove from cart. ('x' to go back to home)");
                            Product foundProduct = searchProductByName(cart, removeProductInput);
                            if (foundProduct != null) {
                                removeFromCart(cart, foundProduct);
                                displayCart();

                            } else {
                                System.out.println("Product not found.");
                            }
                        }
                        else if(displayCartInput.equalsIgnoreCase("x")) {
                            System.out.println("returning to home screen");
                            break;
                        } else {
                                System.out.println("invalid input");
                                break;
                        }

                    } break;



                case "x":
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("Invalid Input, Try Again.");
                    break;

            }
        }
    }

    public static String promptMaker(String prompt){
        System.out.println(prompt);
        return inputScanner.nextLine();
    }

    public static ArrayList<Product> productListMethod() {

        ArrayList<Product> productList = new ArrayList<>();
        try {
//            ArrayList<Product> productList = new ArrayList<>();
            FileReader fileReader = new FileReader("./src/main/resources/products.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);
            String headerLine = buffReader.readLine();
            String input;
            while((input = buffReader.readLine()) != null) {
                String[] productInfo = input.split("\\|");

                String sku = productInfo[0];
                String productName = productInfo[1];
                Double price = Double.parseDouble(productInfo[2]);
                String department = productInfo[3];

                Product product = new Product(sku,productName,price,department);
                productList.add(product);

            }
            buffReader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
            for(Product product : productList) {
                System.out.println(product);

        }

        return productList;

    }



    public static void printArrayMethods(ArrayList<Product> array) {

        for(Product product : array) {
            System.out.println(product);
        }

    }

    public static Product searchProductByName(ArrayList<Product> productList, String productName) {
        for(Product product : productList){
            if(product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        // if Product not found

        return null;
    }
    // USERS CART METHODS
    public static void displayCart() {
        if(cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println(" Your cart: ");
            double totalAmount = 0;
            for(Product product : cart){
                totalAmount += product.getPrice();
                System.out.println(product);
            }
            System.out.printf("  Your cart total: $%.2f\n", totalAmount);
        }
    }

    public static void addToCart(ArrayList<Product> cart, Product product) {
        cart.add(product);
        System.out.println(product.getProductName() + " has been added to your cart.");
    }

    public static void removeFromCart(ArrayList<Product> cart, Product product) {
        cart.remove(product);
        System.out.println("x1: " + product.getProductName() + " has been removed from your cart.");
    }
}




