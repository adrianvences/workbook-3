package searchInventory;

import java.io.BufferedReader;
import java.io.FileReader;


public class StoreApp {

    public static void main(String[] args) {


        try {

            //create fileReader
            FileReader fileReader = new FileReader("./src/main/resources/inventory.csv");
            //bufferedReader to read from file
            BufferedReader bufreader = new BufferedReader(fileReader);

            System.out.println("We carry the following inventory: ");
            String input;

            // while loop continues until there is no next line
            while((input = bufreader.readLine()) !=null) {
                // each line of text is assigned to input and then printed out here.
                System.out.println(input);
            }
            bufreader.close();

        } catch (Exception e ) {
            System.out.println(e.getStackTrace());
        }
    }


}
