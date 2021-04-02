
/**
 * The driver class where main is executed to ask user what they want to do
 * Student: Datt Patel
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;

public class Driver {

    // instance variables (add more as needed)
    private static ArrayList<Ship> shipList = new ArrayList();
    private static ArrayList<Cruise> cruiseList = new ArrayList();
    private static ArrayList<Passenger> passengerList = new ArrayList();

    public static void main(String[] args) {
        // String variable used to hold the user input
        String userInput = "";
        // Scanner object
        Scanner scnr = new Scanner(System.in);

        initializeShipList();       // initial ships
        initializeCruiseList();     // initial cruises
        initializePassengerList();  // initial passengers

        // add loop and code here that accepts and validates user input
        // and takes the appropriate action. include appropriate
        // user feedback and redisplay the menu as needed
        while(!(userInput.equalsIgnoreCase("x"))){
            displayMenu(); // Displays the menu for user
            userInput = scnr.nextLine(); // Gets users input for menu option

            // Goes to case depending on user input, if user input not in menu displays a message
            switch (userInput){
                case "1":
                    addShip(scnr); // Calls the add ship function
                    break;
                case "2":
                    editShip(); // Calls the edit ship function
                    break;
                case "3":
                    addCruise(scnr); // Calls the add cruise function
                    break;
                case "4":
                    editCruise(); // Calls the edit cruise function
                    break;
                case "5":
                    addPassenger(scnr); // Calls the add passengers function
                    break;
                case "6":
                    editPassenger(); // Calls the edit passengers function
                    break;
                case "A":
                    printShipList("name"); // Calls the function that prints ship name
                    break;
                case "B":
                    printShipList("active"); // Calls the function that prints list of ships that are active
                    break;
                case "C":
                    printShipList("full"); // Calls the function to print all ships details
                    break;
                case "D":
                    printCruiseList("list"); // Calls the function that prints cruise list
                    break;
                case "E":
                    printCruiseList("details"); // Calls the function that prints cruise list details
                    break;
                case "F":
                    printPassengerList(); // Calls Passenger list function
                    break;
                case "x":
                    System.out.println("Thank you! Goodbye!"); // Ends the program
                    break;
                default:
                    // In the event user enters an invalid input
                    System.out.println("Please choose only from the options in the menu.");
            }
        }
    }

    // hardcoded ship data for testing
    // Initialize ship list
    public static void initializeShipList() {
        add("Candy Cane", 20, 40, 10, 60, true);
        add("Peppermint Stick", 10, 20, 5, 40, true);
        add("Bon Bon", 12, 18, 2, 24, false);
        add("Candy Corn", 12, 18, 2, 24, false);
    }

    // hardcoded cruise data for testing
    // Initialize cruise list
    public static void initializeCruiseList() {
        Cruise newCruise = new Cruise("Southern Swirl", "Candy Cane", "Miami", "Cuba", "Miami");
        cruiseList.add(newCruise);
    }

    // hardcoded cruise data for testing
    // Initialize passenger list
    public static void initializePassengerList() {
        Passenger newPassenger1 = new Passenger("Neo Anderson", "Southern Swirl", "STE");
        passengerList.add(newPassenger1);

        Passenger newPassenger2 = new Passenger("Trinity", "Southern Swirl", "STE");
        passengerList.add(newPassenger2);

        Passenger newPassenger3 = new Passenger("Morpheus", "Southern Swirl", "BAL");
        passengerList.add(newPassenger3);
    }

    // custom method to add ships to the shipList ArrayList
    public static void add(String tName, int tBalcony, int tOceanView, int tSuite, int tInterior, boolean tInService) {
        Ship newShip = new Ship(tName, tBalcony, tOceanView, tSuite, tInterior, tInService);
        shipList.add(newShip);
    }

    public static void printShipList(String listType) {
        /*printShipList() method prints list of ships from the
        shipList ArrayList. There are three different outputs
        based on the listType String parameter:
        name - prints a list of ship names only
        active - prints a list of ship names that are "in service"
        full - prints tabbed data on all ships
        */
        if (shipList.size() < 1) {
            System.out.println("\nThere are no ships in ship list. Returning to main menu...");
            return;
        }
        if (listType == "name") {
            System.out.println("\n\nSHIP LIST - Name");
            for (int i = 0; i < shipList.size(); i++) {
                System.out.println(shipList.get(i));
            }
        }
        else if (listType == "active") {
            System.out.println("\n\nSHIP LIST - Active");
            // Conuter used to count how many active ships
            int activeCoutner = 0;
            for (Ship eachShip: shipList){
                // Checks if ship is active
                if(eachShip.getInService()) {
                    activeCoutner += 1; // Increases counter if a ship
                    System.out.println(eachShip.getShipName()); // Prints out ship name
                }
            }
            // If no active ships prints out a statement for user
            if (activeCoutner == 0){
               System.out.println("There are no active ships.");
            }
        }
        else if (listType == "full") {
            System.out.println("\n\nSHIP LIST - Full");
            System.out.println("-----------------------------------------------");
            System.out.println("                    Number of Rooms     In");
            System.out.print("SHIP NAME           Bal OV  Ste Int     Service");
            System.out.println("\n-----------------------------------------------");
            for (Ship eachShip: shipList)
                eachShip.printShipData();
        }
    }

    public static void printCruiseList(String listType) {
        if (cruiseList.size() < 1) {
            System.out.println("\nThere are no cruises in list. Returning to main menu...");
            return;
        }
        if (listType == "list") {
            System.out.println("\n\nCRUISE LIST");
            for (int i=0; i < cruiseList.size(); i++) {
                System.out.println(cruiseList.get(i));
            }
        } else if (listType == "details") {
            System.out.println("\n\nCRUISE LIST - Details");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("                                      |----------------------PORTS-----------------------|");
            System.out.print("CRUISE NAME         SHIP NAME           DEPARTURE           DESTINATION         RETURN");
            System.out.println("\n-----------------------------------------------------------------------------------------");
            for (Cruise eachCruise: cruiseList)
                eachCruise.printCruiseDetails();
        }
    }

    public static void printPassengerList() {
        if (passengerList.size() < 1) {
            System.out.println("\nThere are no passengers to print.");
            return;
        }
        System.out.println("\n\nPASSENGER LIST");
        System.out.println("-----------------------------------------------------");
        System.out.print("PASSENGER NAME      CRUISE              ROOM TYPE");
        System.out.println("\n-----------------------------------------------------");
        for (Passenger eachPassenger: passengerList)
            eachPassenger.printPassenger();
    }

    // display text-based menu
    public static void displayMenu() {

        System.out.println("\n\n");
        System.out.println("\t\t\tLuxury Ocean Cruise Outings");
        System.out.println("\t\t\t\t\tSystem Menu\n");
        System.out.println("[1] Add Ship            [A] Print Ship Names");
        System.out.println("[2] Edit Ship           [B] Print Ship In Service List");
        System.out.println("[3] Add Cruise          [C] Print Ship Full List");
        System.out.println("[4] Edit Cruise         [D] Print Cruise List");
        System.out.println("[5] Add Passenger       [E] Print Cruise Details");
        System.out.println("[6] Edit Passenger      [F] Print Passenger List");
        System.out.println("[x] Exit System");
        System.out.println("\nEnter a menu selection: ");
    }

    /**
     * Adds a new ship by taking user inputs , looping till valid inputs are entered, making a new ship object with data
     * and entering the new Ship object in shipList
     * @param newShipInput, Scanner object that allows us to use only one scanner object whole program
     */
    public static void addShip(Scanner newShipInput) {

        // Stores the new ship name that user enters
        String newShipName;

        // Array that will hold the number of type of rooms in ship
        // The order of the array :BAL, OV, STE, INT
        int[] shipRooms = new int[4];

        // variables holds whether ship is active or not. Start value = false
        boolean shipActive = false;

        // variable used to end user input loop for each input
        boolean invalidInput = true;

        // Checks that ship does not exist in system and if exists loops till user enters a new ship name
        do {
            System.out.println("Enter new ship's name: ");
            newShipName = newShipInput.nextLine();

            // The function shipIsInList(string) is used to check if ship user entered is in shipList or not
            // If it is then returns true else returns false
            if (!(shipIsInList(newShipName))) {
                // Checks that ship name is not a number
                if(isANumber(newShipName)){
                    System.out.println("The input is an number not name.");
                    System.out.println();
                }else{
                    invalidInput = false;
                }
            }
            else {
                System.out.println("Ship already exists.");
                System.out.println();
            }
        }while(invalidInput);

        //This used to get user input for each type of room on ship and validate it
        //@see shipRoomInput() in Driver.java
        shipRooms = shipRoomInput(newShipInput);

        invalidInput = true; // Changes invalidInput back to starting value

        // Validates the boolean active input, looping till it user enters a valid input
        do{
            try {
                System.out.println("Ship is active: (Enter \"true\"/\"false\")");
                shipActive = newShipInput.nextBoolean();// May throw exception
                invalidInput = false;
            }
            catch(Exception except){
                System.out.println("Please enter a valid input (valid input = true/false)");
                System.out.println(); // Space for better clarity
                invalidInput = true;
            }
            finally{
                newShipInput.nextLine();
            }
        }while(invalidInput);

        // This is used to pass on collected data so new Ship object with the data can be created and added to shipList
        // @see add() method
        add(newShipName, shipRooms[0], shipRooms[1], shipRooms[2], shipRooms[3], shipActive);
    }

    // Edit an existing ship
    public static void editShip() {

        // This method does not need to be completed
        System.out.println("The \"Edit Ship\" feature is not yet implemented.");

    }

    /**
     * Allows us to add a new cruise ship by taking in user inputs of needed data, validates the data and
     * adds new cruise object with the data to cruise list
     * @param newCruiseScanner, scanner object for this method allowing us to keep only one Scanner object in the
     * whole program
     */
    public static void addCruise(Scanner newCruiseScanner) {

        // initialize variables for use
        String newCruiseName, cruiseShipName, departurePort, destination = "", returnPort = "";

        boolean invalidInput = true; // To end loop is input is valid


        // Takes Cruise name until valid name is entered
        do {
            System.out.println("Enter new cruise's name: ");
            newCruiseName = newCruiseScanner.nextLine();
            // Ensures that name is not a number
            if (!(isANumber(newCruiseName))) {
                // Ensures name of cruise does not exists
                for (Cruise eachCruise : cruiseList) {
                    if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                        System.out.println("Cruise already exists.");
                        System.out.println();
                        invalidInput = true;
                        break;
                    }
                    else{
                        invalidInput = false;
                    }
                }
            }
            else{
                System.out.println("Please enter a name not a number.");
                System.out.println();
            }
        } while (invalidInput);

        invalidInput = true; // Changes invalid back to start value

        // Takes Ship name, and loops till fully valid (if there is a ship with entered name, checks if ship in service
        // and checks that ship is not in use by another cruise)
        do {
            boolean passOn = false; // This is used only when checking cruise ship name, if ship is in list and active
                                    // this value becomes true and then checks if ship is in use by anyone

            System.out.println("Enter the ship's name for new cruise: ");
            cruiseShipName = newCruiseScanner.nextLine();

            // Loops through each ship in shipList
            for (int i = 0; i < shipList.size(); i++) {
                // Checks if the ship name in list is equal to new cruise ship name
                if (shipList.get(i).getShipName().equalsIgnoreCase(cruiseShipName)) {
                    // Checks if the new cruise's ship is active or not
                    if (!(shipList.get(i).getInService())) {
                        System.out.println("The ship is not active.");
                        System.out.println();
                        break;
                    }
                    // If ship is active and in ship list we break from loop and continue with program
                    else {
                        passOn = true;
                        break;
                    }
                } else if (i == (shipList.size() - 1)) {
                    System.out.println("There is no ship with that name.");
                    System.out.println();
                    break;
                }
            }

           if (passOn){
               // Checks that a cruise is not using this ship
               for (Cruise eachCruise : cruiseList) {
                   // Checks if there is a cruise already using the ship
                   if (eachCruise.getCruiseShipName().equalsIgnoreCase(cruiseShipName)) {
                       System.out.println("A cruise is already using this ship.");
                       System.out.println();
                       invalidInput = true;
                       break;
                   }
                   invalidInput = false;
               }
           }
        } while (invalidInput);

        invalidInput = true;

        do {// Validates departure port input of new cruise
            System.out.println("Enter the port of departure for new cruise: ");
            departurePort = newCruiseScanner.nextLine();

            if (isANumber(departurePort)) { // Checks that input is not a number
                System.out.println("Input was a number not a location.");
                System.out.println();
                invalidInput = true;
            }
            else {
                invalidInput = false;
            }
        }while(invalidInput);

        invalidInput = true;

        do {// Validates the destination of new cruise
            System.out.println("Enter the destination for new cruise: ");
            destination = newCruiseScanner.nextLine();

            if (isANumber(destination)) {// Checks that input is not a number
                System.out.println("Input was a number not a location.");
                System.out.println();
                invalidInput = true;
            }
            else{
                invalidInput = false;
            }
        }while(invalidInput);

        invalidInput = true;

        do {// Validates the return port input for new cruise
            System.out.println("Enter the return port for new cruise: ");
            returnPort = newCruiseScanner.nextLine();

            if (isANumber(returnPort)) {// Checks that input is not a number
                System.out.println("Input was a number not a location.");
                System.out.println();
                invalidInput = true;
            }else{
                invalidInput = false;
            }
        }while(invalidInput);


        // Makes new cruise object and adds the data we have taken from user
        Cruise newCruise = new Cruise(newCruiseName, cruiseShipName, departurePort, destination, returnPort);

        // Adds new cruise object to cruiseList
        cruiseList.add(newCruise);
    }

    // Edit an existing cruise
    public static void editCruise() {
        // This method does not need to be completed
        System.out.println("The \"Edit Cruise\" feature is not yet implemented.");
    }

    // Add a New Passenger
    public static void addPassenger(Scanner newPassengerInput) {

        System.out.println("Enter the new passenger's name: ");
        String newPassengerName = newPassengerInput.nextLine();

        // ensure new passenger name does not already exist
        for (Passenger eachPassenger: passengerList) {
            if (eachPassenger.getPassengerName().equalsIgnoreCase(newPassengerName)) {
                System.out.println("That passenger is already in the system. Exiting to menu...");
                return; // quits addPassenger() method processing
            }
        }

        // get cruise name for passenger
        System.out.println("Enter cruise name: ");
        String newCruiseName = newPassengerInput.nextLine();

        // ensure cruise exists
        // FIXED IT CAUSE IT WAS NOT CHECKING ALL CRUISES ONLY THE FIRST CURISE WAS GETTING CHECKED
        for (Cruise eachCruise: cruiseList) {
            if (eachCruise.getCruiseName().equalsIgnoreCase(newCruiseName)) {
                // cruise does exist
                break;
            }
            // Only breaks out if the last cruise element is equal to the last loop element
            else if (cruiseList.get(cruiseList.size() -1).equals(eachCruise)){
                System.out.println("That cruise does not exist in the system. Exiting to menu...");
                return;
            }
        }

        // get room type
        System.out.println("Enter Room Type (BAL, OV, STE, or INT: ");
        String room = newPassengerInput.nextLine();
        // validate room type
        if ((room.equalsIgnoreCase("BAL")) || (room.equalsIgnoreCase("OV")) ||
                (room.equalsIgnoreCase("STE")) || (room.equalsIgnoreCase("INT"))) {
            // validation passed - add passenger
            Passenger newPassenger = new Passenger(newPassengerName, newCruiseName, room.toUpperCase());
            passengerList.add(newPassenger);
        } else {
            System.out.println("Invalid input. Exiting to menu...");
            return; // quits addPassenger() method processing
        }
    }

    // Edit an existing passenger
    public static void editPassenger() {

        // This method does not need to be completed
        System.out.println("The \"Edit Passenger\" feature is not yet implemented.");

    }

    // Method to check if input is a number
    public static boolean isANumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            // If the first character is a "-" it moves onto to next character instead of stating that input
            // is not a number
            if(!((Character.compare(str.charAt(i), '-')) == 0)){
                if (Character.isDigit(str.charAt(i)) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    /** Methods made by me*/

    /**
     * This function is used to check whether there is a ship of argument in the arrayList shipList
     * @author Datt Patel
     * @param newShipName, the name of ship you want to check
     * @return true if there is a ship of given name else returns false
     */
    public static boolean shipIsInList(String newShipName){
        for(Ship eachShip: shipList){
            if(eachShip.getShipName().equalsIgnoreCase(newShipName)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the string user entered is a number, if it is, then checks that it is greater than equal to 0
     * @param str, the string that user entered
     * @return user input converted to integer if it passes both checks otherwise returns -1
     * *@see isANumber()
     */
    public static int validationShipRooms(String str){
        if(isANumber(str)){
            // Hold the parsed integer value in tempVar so we do not have to parse the integer again on return
            int tempVar = Integer.parseInt(str);
            if(0 <= tempVar) {
                return tempVar;
            }
        }
        return -1;
    }

    /**
     * This method is used to get number of each type of room on ship and loops until a valid input is entered by user
     * @param scnrRoomInput, Scanner for cleaner code
     * @return shipRooms, int[], array holds number of each type of room on ship
     * *@see validaitonShipRooms[], in Driver.java
     */
    public static int[] shipRoomInput(Scanner scnrRoomInput){

        // Array used to hold type of each room so it can be outputed to user, clarifying which type of room input
        // program is asking for
        String[] roomNames = new String[]{"Balcony cabins", "Ocean view cabins", "Suite cabins", "Interior cabins"};

        // Array used to hold number of each type of room in ship
        int[] shipRooms = new int[4];

        boolean invalid; // Used to end while loop
        int tempInt; // temporarily holds the return value from validationShipRooms method

        for(int i = 0; i < shipRooms.length; i ++){
            invalid = true;

            // temporarily holds user input
            String tempStr = "";

            do {
                System.out.println("Enter number of " + roomNames[i] + " in ship: ");
                tempStr = scnrRoomInput.nextLine(); // Gets user input
                tempInt = validationShipRooms(tempStr); // Sends user input for validation and takes in return value

                if (tempInt == -1){ // If return value is -1 then user input is not valid
                    System.out.println("Invalid number. Please enter a valid number");
                    System.out.println(); // Extra space for clarity
                }else{
                    shipRooms[i] = tempInt; // Changes the stored array value
                    invalid = false;
                }
            }while(invalid);
        }
        return shipRooms;
    }
}