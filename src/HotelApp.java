import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HotelApp {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<String> customerTextLines = new ArrayList<>();
    private ArrayList<Customer> customerArrayList = new ArrayList<>();

    private ArrayList<String> employeeTextLines = new ArrayList<>();
    private ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public static void main(String[] args) {

        HotelApp hotelApp = new HotelApp();
        try {
            hotelApp.readCustomerList();
            hotelApp.readEmployeeList();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

            System.out.print("Username: ");
            String name = hotelApp.sc.nextLine();
            System.out.print("Password: ");
            String password = hotelApp.sc.nextLine();

            for (int i = 0; i < hotelApp.employeeArrayList.size(); i++) {
                if (name.equalsIgnoreCase(hotelApp.employeeArrayList.get(i).getName()) && password.equalsIgnoreCase(hotelApp.employeeArrayList.get(i).getPassword())) {
                    hotelApp.employeeMode();
                } else {
                    for (int j = 0; j < hotelApp.customerArrayList.size(); j++) {
                        if (name.equalsIgnoreCase(hotelApp.customerArrayList.get(i).getName()) && password.equalsIgnoreCase(hotelApp.customerArrayList.get(i).getPassword())) {
                            hotelApp.customerMode();
                        }
                    }
                }
            }

        }
    }


    public void employeeMode() {
        byte choice = 0;
        while (choice != 11) {

            System.out.println("\n\n*** Welcome to the Hotel California *** ");
            System.out.println("\t\t\t|Employee|\n");
            System.out.println("[1]  Add a new customer");
            System.out.println("[2]  Remove a customer");
            System.out.println("[3]  View all customers");

            System.out.println("[4]  Add a new room");
            System.out.println("[5]  Remove a room");
            System.out.println("[6]  View all rooms including availability status");
            System.out.println("[7]  View available rooms");
            System.out.println("[8]  Edit the information of an existing room");

            System.out.println("[9]  Search for a particular booking ");
            System.out.println("[10] Exit the employee mode");
            System.out.print("\nYour choice: ");

            try {
                choice = sc.nextByte();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("| Please choose a number from the menu! |\n");
                sc.next();
                continue;
            }

            switch (choice) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    break;
                }
                case 9: {
                    break;
                }
                case 10: {
                    System.out.println("Exiting the employee mode\n\n\n\n");
                    choice = 11;
                    break;
                }
                default: {
                    System.out.println("| Please choose a number from the menu! |\n");

                }
            }
        }
    }

    public void customerMode() {
        byte choice = 0;

        while (choice != -1) {
            System.out.println("\n\n*** Welcome to the Hotel California *** ");
            System.out.println("\t\t\t|Customer|\n");
            System.out.println("[1] Make a booking and Check-in");
            System.out.println("[2] Check-out");
            System.out.println("[3] View current and previous bookings");
            System.out.println("[4] View a list of all available rooms in a requested period");
            System.out.println("[5] View bookings´ history");
            System.out.println("[6] Edit profile");
            System.out.println("[7] Edit information of a particular booking");
            System.out.println("{8] Exit");
            System.out.print("\nYour choice: ");
            try {
                choice = sc.nextByte();
            } catch (Exception e) {
                System.out.println("| Please choose a number from the menu! |\n");
                sc.next();
                continue;
            }

            switch (choice) {
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
                    break;
                }
                case 6: {
                    break;
                }
                case 7: {
                    break;
                }
                case 8: {
                    System.out.println("Thank you for dealing with Hotel California\n\n");
                    choice = -1;
                    break;
                }
                default: {
                    System.out.println("| Please choose a number from the menu! |\n");
                    break;
                }
            }
        }
        sc.nextLine();

    }

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

}

