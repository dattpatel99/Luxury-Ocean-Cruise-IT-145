/**
 * A class representing cruise ship data in
 * name, ship name, departure port, destination, return port
 * Student: Datt Patel
 */
public class Cruise {

    // Instance Variables
    private String cruiseName;
    private String cruiseShipName;
    private String departurePort;
    private String destination;
    private String returnPort;

    // Constructor - default
    Cruise() {
    }

    // Constructor - full
    Cruise(String tCruiseName, String tShipName, String tDeparture, String tDestination, String tReturn) {
        cruiseName = tCruiseName;
        cruiseShipName = tShipName;
        departurePort = tDeparture;
        destination = tDestination;
        returnPort = tReturn;
    }

    // Accessors
    public String getCruiseName() {
        return cruiseName;
    }

    public String getCruiseShipName() {
        return cruiseShipName;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getDestination() {
        return destination;
    }

    public String getReturnPort() {
        return returnPort;
    }

    // Mutators
    public void setCruiseName(String tVar) {
        cruiseName = tVar;
    }

    public void setCruiseShipName(String tVar) {
        cruiseShipName = tVar;
    }

    public void setDeparturePort(String tVar) {
        departurePort = tVar;
    }

    public void setDestination(String tVar) {
        destination = tVar;
    }

    public void setReturnPort(String tVar) {
        returnPort = tVar;
    }

    // print cruise details
    public void printCruiseDetails() {
        // A string to hold number of spaces to make the print column clean
        String spaces = "";

        spaces = createSpaces(cruiseName.length()); // Gets number of spaces to place after Cruise Name
        System.out.print(cruiseName + spaces);

        spaces = createSpaces(cruiseShipName.length()); // Gets number of spaces to place after Cruise Ship Name
        System.out.print(cruiseShipName + spaces);

        spaces = createSpaces(departurePort.length()); // Gets number of spaces to place after Departure Port
        System.out.print(departurePort + spaces);

        spaces = createSpaces(destination.length()); // Gets number of spaces to place after Destination
        System.out.println(destination + spaces + returnPort);
    }

    /**
     * This method is used to calculate the number of spaces to place after variable so that the table looks clean
     * Table has a gap length of 20 between columns hence the constant value 2
     * @param nameLength, is the length of given argument
     * @return the string of spaces to add after the argument
     */
    private String createSpaces(int nameLength){
        String spaces = "";
        for (int i = 1; i <= (20 - nameLength); i++){
            spaces = spaces + " ";
        }
        return spaces;
    }

    // method added to print ship's name vice memory address
    @Override
    public String toString() {
        return cruiseName;
    }


}
