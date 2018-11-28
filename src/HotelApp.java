import java.util.Scanner;

public class HotelApp {

    private Scanner scan = new Scanner(System.in);
    private HotelLogic hotelCL;

    public static void main(String[] args) {
        HotelApp main = new HotelApp();
        main.mainMenu();
    }

    public void mainMenu() {
        hotelCL = new HotelLogic(scan);
        String option;
        while (true) {

            System.out.print("*** Welcome to Hotel California! ***\n\n" +
                    "Please choose an option from the menu:\n" +
                    "1. Login User\n" +
                    "2. Show Hotel Information\n" +
                    "3. Exit System\n\n" +
                    "Your choice: ");

            option = scan.nextLine();

            switch (option) {
                case "1":
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option Not available, please choose an option from menu");
                    break;
            }
        }
    }


    public void showHotelInfo() {
        /*
        Skriv lite basic info om Hotellet
         */
    }

}

