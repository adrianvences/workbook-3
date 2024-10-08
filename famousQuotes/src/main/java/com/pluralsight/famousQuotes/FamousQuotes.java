package com.pluralsight.famousQuotes;

import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {

    public String[] famousQuotes = {
            "The only way to do great work is to love what you do. – Steve Jobs",
            "In three words I can sum up everything I've learned about life: it goes on. – Robert Frost",
            "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment. – Ralph Waldo Emerson",
            "Life is what happens when you're busy making other plans. – John Lennon",
            "The best way to predict the future is to invent it. – Alan Kay",
            "The only limit to our realization of tomorrow will be our doubts of today. – Franklin D. Roosevelt",
            "What lies behind us and what lies before us are tiny matters compared to what lies within us. – Ralph Waldo Emerson",
            "The only thing we have to fear is fear itself. – Franklin D. Roosevelt",
            "Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment. – Buddha",
            "Success is not final, failure is not fatal: It is the courage to continue that counts. – Winston S. Churchill"
    };

    public static void famousQuotePicker(){
        Scanner userInput = new Scanner(System.in);
        System.out.print("Hello enter a number 1 - 10 (digits only): ");
        int usersNumber = userInput.nextInt();
        //this line creates an instance of the famousQuotes arr
        FamousQuotes quotesList = new FamousQuotes();
        try {
            System.out.println(quotesList.famousQuotes[usersNumber-1]);
        } catch (Exception e) {
            System.out.println("invalid number");
        }
    }

    public static int randomGenerator(){
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        famousQuotePicker();
        while(true) {
            System.out.println("Enter \n 'a' to enter another 1-10 number for a quote. \n 'b' for a random quote. \n 'x' to exit\n");
            String menuInput = userInput.nextLine();
            switch (menuInput.toLowerCase()) {
                case "a":
                    famousQuotePicker();
                    break;

                case "b":
                    //this line creates an instance of the famousQuotes arr
                    FamousQuotes quotesList = new FamousQuotes();
                    System.out.println(quotesList.famousQuotes[randomGenerator()]);


                case "x":
                    break;

            }

            // if statement to turn while loop from true to false
            System.out.print("Do you want to continue? (yes/no):");
            String continueInput = userInput.nextLine();
            if (continueInput.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
                break;
            }
        }




//        //input validation
//        if(usersNumber >= 1 && usersNumber <= 10) {
//            System.out.println("Here is your quotes.");
//            // prints out quote but subtracts number by one because index are 0 based
//            System.out.println(quotesList.famousQuotes[usersNumber-1]);
//        } else {
//            // invalid input
//            System.out.println("Invalid Number");
//        }

    }
}
