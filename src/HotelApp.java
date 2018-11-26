import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class HotelApp {

    private Scanner scan = new Scanner(System.in);
    private HotelLogic hotelCL;

    public static void main(String[] args) {
        HotelApp main = new HotelApp();
        main.mainMenu();
    }

    public void mainMenu(){

        String option;

        while(true) {

            System.out.println("*** Welcome to Hotel California! ***\n\n" +
                    "Please choose an option from the menu:\n" +
                    "1. Login User\n" +
                    "2. Show Hotel Information\n" +
                    "3. Exit System\n");

            option = scan.nextLine();

            switch (option) {
                case "1":
                    hotelCL = new HotelLogic(scan);
                    try {
                        hotelCL.loginUser();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    showHotelInfo();
                    break;

                case "3":
                    System.exit(1);
                    break;
                default:
                    System.out.println("Option Not available, please choose an option from menu");
                    break;
            }
        }
    }


    public void showHotelInfo(){
        /*
        Skriv lite basic info om Hotellet
         */
    }

    /*
    Refactoring this to Logic class since List of users is moved there and general logic is more appropiate


    public void readCustomerList() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("CustomerLogin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        while (line != null) {
            line = br.readLine();
            if (line != null) {
                customerTextLines.add(line);
            }
        }
        br.close();
        for (String separate : customerTextLines) {
            String[] item = separate.split(Pattern.quote("%%%"));
            Customer customer = new Customer(item[0], item[1], item[2], item[3], item[4]);
            customerArrayList.add(customer);
            //The statement below does not seem to work!!
            // hotelLogic.addCustomer(new Customer(item[0], item[1], item[2], item[3], item[4]));
        }

    }

    public void readEmployeeList() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("EmployeeLogin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        while (line != null) {
            line = br.readLine();
            if (line != null) {
                employeeTextLines.add(line);
            }
        }
        br.close();
        for (String separate : employeeTextLines) {
            String[] item = separate.split(Pattern.quote("%%%"));
            Employee employee = new Employee(item[0], item[1]);
            employeeArrayList.add(employee);
        }
    }

    */

}

