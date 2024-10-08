package com.pluralsight.payrollCalculator;


// import java.io.*;
//public class Program
//{
//  public static void main(String args[])
//  {
//      try
//      {
////        create a FileReader object connected to the File
//          FileReader fileReader = new FileReader("poem.txt");
////        create a BufferedReader to manage input stream
//          BufferedReader bufReader = new BufferedReader(fileReader);
//          String input;
////        read until there is no more data
//          while((input = bufReader.readLine()) != null) {
//          System.out.println(input);
//          }
////        close the stream and release the resources
//          bufReader.close();
//}
//  catch(IOException e) {
////    display stack trace if there was an error
//         e.printStackTrace();


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Payroll {

    public static void main(String[] args) {
        //try block to handle exceptions will jump to catch if there is one
        try {
            // created a FileReader with file
            FileReader fileReader = new FileReader("./src/main/resources/employees.csv");
            // created buffer reader to read text from stream fileReader
            BufferedReader buffReader = new BufferedReader(fileReader);
            // Skip the header line
            buffReader.readLine();

            // input to assign each line from while loop
            String input;
            // as long as buffReader.readLine() does not return null each line from the file will be assigned to input
            while((input = buffReader.readLine()) != null) {
                // String array that splits each line at "|"
                String[] employeeInfo = input.split("\\|");

                // Parce data into each correct data type for constructor
                int id = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);

                Employee employee = new Employee(id,name,hoursWorked,payRate);
                System.out.printf("Employee ID: %d, Employee Name: %s, Gross pay: $%.2f \n", employee.getEmployeeId(),employee.getName(),employee.getGrossPay());

                // prints input through each iteration of the loop
//                System.out.println(Arrays.toString(employeeInfo));
            }
            buffReader.close();

            //IOException just in case there is error
        } catch(IOException e) {
            // this provides details about the error in console if there is an error
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("error parsing number: " + e.getMessage());
        }

    }

}
