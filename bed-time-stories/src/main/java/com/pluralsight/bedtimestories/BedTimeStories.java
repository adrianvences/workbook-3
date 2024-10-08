package com.pluralsight.bedtimestories;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BedTimeStories {
    public static void main(String[] args) throws FileNotFoundException {

        //infinite loop to continue showing menu
        while (true) {
            // welcome message
            System.out.println("Welcome to the story reader Enter  \n 'a' for Goldilocks \n 'b' for Hansel and Gretel \n 'c' for Mary had a Little Lamb \n 'x' to exit" );
            //scanner
            Scanner userInput = new Scanner(System.in);
            //user input
            String menuInput = userInput.nextLine();

            // switch statement for user choices
            switch (menuInput.toLowerCase()) {
                case "a":
                    readStory("goldilocks.txt");
                    break;
                case "b":
                    readStory("hansel_and_gretel.txt");
                    break;
                case "c":
                    readStory("mary_had_a_little_lamb.txt");
                    break;
                case "x":
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("invalid input");

            }

        }
    }
    //method to read contents of file
    private static void readStory(String filename) throws FileNotFoundException {

        //used to read file with directory string
        FileInputStream fis = new FileInputStream("./src/main/resources/" + filename);

        //reads fis output
        Scanner fileScanner = new Scanner(fis);

        // while loop to continue reading , hasNextLine returns true if there is another line
        while(fileScanner.hasNextLine()) {

            //fileScanner output is stored in input variable
            String input = fileScanner.nextLine();
            System.out.println(input);
        }
        fileScanner.close();
    }
}
