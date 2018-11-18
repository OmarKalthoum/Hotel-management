import java.util.Scanner;

public class HotelApp {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        HotelApp hotelApp = new HotelApp();
        //  HotelLogic hotelLogic = new HotelLogic();

        byte choice = 0;
        while (choice != 4) {
            hotelApp.showMenu();
            try {
                choice = hotelApp.sc.nextByte();
                hotelApp.sc.nextLine();
            } catch (Exception e) {
                System.out.println("| Please choose a number from the menu! |\n");
                hotelApp.sc.next();
                continue;
            }
            switch (choice) {
                case 1: {
                    hotelApp.adminMode();
                    break;
                }
                case 2: {
                    hotelApp.customerMode();
                    break;
                }
                case 3: {
                    System.out.print("Are you sure you want to exit(Y/N): ");
                    String exitChoice = hotelApp.sc.nextLine();
                    if (exitChoice.equalsIgnoreCase("y")) {
                        System.out.println("Thank you and good bye!");
                        choice = 4;
                    } else {
                        System.out.println("\n");
                    }
                    break;
                }
                default: {
                    System.out.println("| Please choose a number from the menu! |\n");
                }
            }
        }

    }

    public void showMenu() {
        System.out.println("Welcome to the Hotel California! ");
        System.out.printf("[1] %s%n[2] %s%n[3] Exit%nYour choice: ", "Admin", "Customer");
    }

    public void adminMode() {
        byte choice = 0;
        while (choice != -1) {

            System.out.println("For debugging purpose the password is: 0753");
            System.out.print("Please confirm your password to enter the admin mode: ");
            String adminPassword = sc.nextLine();
            if (adminPassword.equals("0753")) {
                choice = -1;

            } else {
                System.out.println("The password is invalid, please try again!\n");
            }
        }
        while (choice != 11) {


            System.out.println("\n*** Welcome ***\n");
            System.out.println("[1] Add a new customer");
            System.out.println("[2] Remove a customer");
            System.out.println("[3] View all customers");

            System.out.println("[4] Add a new room");
            System.out.println("[5] Remove a room");
            System.out.println("[6] View all rooms including availability status");
            System.out.println("[7] View available rooms");
            System.out.println("[8] Edit the information of an existing room");

            System.out.println("[9] Search for a particular booking ");
            System.out.println("[10] Exit the admin mode");
            System.out.print("\nYour choice: ");

            try {
                choice = sc.nextByte();
            } catch (Exception e) {
                System.out.println("| Please choose a number from the menu! |\n");
                sc.next();
                continue;
            }

            //Just a commint
            // so

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
                    System.out.println("Exiting the admin mode\n\n\n\n");
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
            System.out.println("\n\n*** Welcome to the Hotel California ***\n ");
            System.out.println("[1] Make a booking and Check-in");
            System.out.println("[2] Check-out");
            System.out.println("[3] View current and previous bookings");
            System.out.println("[4] Edit your profile");
            System.out.println("[5] Edit information of a particular booking");
            System.out.println("{6] Exit");
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
                case 3:{
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
                    break;
                }
                case 6: {
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

    }
}
