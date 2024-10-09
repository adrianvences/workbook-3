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


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Payroll {

    public static void main(String[] args) {
        //try block to handle exceptions will jump to catch if there is one
        Scanner fileNameScanner = new Scanner(System.in);
        ArrayList<Employee> employeeInfoList = new ArrayList<>();
        System.out.print("Enter the name of the file employee file to process: ");
        String fileToRead = fileNameScanner.nextLine();
        System.out.print("Enter the name of the payroll file to create: ");
        String fileToCreate = fileNameScanner.nextLine();



        try {
            // created a FileReader to read file
            FileReader fileReader = new FileReader("./src/main/resources/employees.csv");
            // created buffer reader to read text from stream fileReader
            BufferedReader buffReader = new BufferedReader(fileReader);
            // Skip the header line
//            buffReader.readLine();

            // create a FileWriter
            FileWriter fileWriter = new FileWriter(fileToCreate);
            // create a buffered writer
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            // header line
            String header = buffReader.readLine();
            String[] headerParts = header.split("\\| \n");
            bufWriter.write(String.format(" %s | %s | %s", headerParts[0],headerParts[1],headerParts[2]));
//            bufWriter.write(" id | name | gross pay\n");

            // input to assign each line from while loop
            String input;
            // as long as buffReader.readLine() does not return null each line from the file will be assigned to input
            while ((input = buffReader.readLine()) != null) {
                // String array that splits each line at "|"
                String[] employeeInfo = input.split("\\|");

                // Parce data into each correct data type for constructor
                int id = Integer.parseInt(employeeInfo[0]);
                String name = employeeInfo[1];
                double hoursWorked = Double.parseDouble(employeeInfo[2]);
                double payRate = Double.parseDouble(employeeInfo[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employeeInfoList.add(employee);
                String employeeData = String.format(" %d | %s | $%.2f \n", employee.getEmployeeId(),employee.getName(),employee.getGrossPay());
                bufWriter.write(employeeData);
                // prints input through each iteration of the loop
//                System.out.println(Arrays.toString(employeeInfo));
            }
            buffReader.close();
            bufWriter.close();

            //IOException just in case there is error
        } catch (IOException e) {
            // this provides details about the error in console if there is an error
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("error parsing number: " + e.getMessage());
//        } finally {
//            for (Employee employee : employeeInfoList) {
//                System.out.printf("Employee ID: %d, Name: %s, Hours Worked: %.2f, Pay Rate: %.2f, Gross Pay: $%.2f\n",
//                        employee.getEmployeeId(), employee.getName(), employee.getHoursWorked(), employee.getPayRate(), employee.getGrossPay());
//            }

        }
    }
}
