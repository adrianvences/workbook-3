package searchEngineLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.spec.ECField;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    public static void main(String[] args) {

        // Gets Local date and time
        LocalDateTime todayDateTime = LocalDateTime.now();

        // date stamp formatter
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-M-dd  HH:mm:ss");

        // initialize buffedWriter
        BufferedWriter buffedWriter = null;

        try {
            //create file writer
            FileWriter fileWriter = new FileWriter("logs.txt",true);
            //create buffedWriter
            buffedWriter = new BufferedWriter(fileWriter);

            //writes launch line with time and date stamp in the logs.txt file
            buffedWriter.write(todayDateTime.format(dateTimeFormat) + " Launch\n");

            //user input
            Scanner userChoice = new Scanner(System.in);

            //while loop to keep prompting search results
            while (true) {
                System.out.println("Enter a search term ('X' to exit)");
                String userInput = userChoice.nextLine();
                if (userInput.equalsIgnoreCase("x")) {
                    System.out.println("Good Bye!");
                    return;
                } else {
                    // formats each result with date and time
                    buffedWriter.write(todayDateTime.format(dateTimeFormat) + "  " + userInput);
                    buffedWriter.newLine();

                }

            }


        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {

            // Check if buffedWriter is not null before trying to write
            if (buffedWriter != null) {
                try {
                    buffedWriter.write(todayDateTime.format(dateTimeFormat) + " Exit\n");
                    buffedWriter.close(); // Close the writer
                } catch (Exception e) {
                    e.printStackTrace(); // Print any exceptions from closing
                }
            }
        }
    }



}
