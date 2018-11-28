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

            try {
                option = scan.nextLine();
            } catch (Exception e) {
                System.out.println("Please choose a number from the menu");
                scan.next();
                continue;
            }


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
            }
        }
    }


    public void showHotelInfo() {

        System.out.println("\n        Welcome to the Hotel California!\n" +
                "        Hotel California is located on the side of a dark desert highway. The warm smell of colitas\n" +
                "        rising up through the air. It´s a lovely place with plenty of room, any time of year!");
        System.out.println();

    }

}

