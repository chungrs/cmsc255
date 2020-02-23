  /*********************************************************
  * Programming Project 7 - Flight Analysis                *
  * ------------------------------------------------------ *
  * This program receives two strings from the command     *
  * line, one containing the input filename and the other  *
  * containing the name of the output file. The program    *
  * organizes the data into an ArrayList of Flight objects *
  * and can remove objects from the ArrayList defined by   *
  * a text file named DataToRemove.txt. The program also   *
  * finds the Flight object with the lowest fare as well   *
  * the one with the lowest price per mile. After reading  *
  * and organizing the data, the program outputs the       *
  * flight information to a user-defined text file in a    *
  * human-readable format.                                 *
  * ------------------------------------------------------ *
  * Roy Chung                                              *
  * 20191117                                               *
  * CMSC 255 Section 1                                     *
  *********************************************************/

package Project7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightAnalysis {
    public static void main(String[] args) {
        //create scanner object that lets user input filename
        Scanner console = new Scanner(System.in);
        String inputFileName;
        String outputFileName;

        //Prompt user for file names if none are entered
        if (args.length < 1) {
            System.out.print("Input file: ");
            inputFileName = console.next();
            System.out.print("Output file: ");
            outputFileName = console.next();
        } else if (args.length < 2) {
            inputFileName = args[0];
            System.out.print("The input file is " + inputFileName + ", please enter the output file: ");
            outputFileName = console.next();
        } else {
            inputFileName = args[0];
            outputFileName = args[1];
        }

        //close scanner
        console.close();

        //Create File objects
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        Scanner in = null;
        try {
            in = new Scanner(inputFile);
        } catch(FileNotFoundException e) {
            System.out.println("Incorrect input filename");
        }
        assert in != null;
        in.close();

        Scanner out = null;
        try {
            out = new Scanner(outputFile);
        } catch(FileNotFoundException e){
            System.out.println("Incorrect output filename");
        }
        assert out != null;
        out.close();

        //Create ArrayList created by passing inputFile into parseData method
        ArrayList<Flight> allFlights = parseData(inputFile);

        //Create removeDataFile File object
        File removeDataFile = new File("dataToRemove.txt");
        //pass above file through parseData to create ArrayList
        ArrayList<Flight> removeItems = parseData(removeDataFile);

        //Pass allFlights and removeItems to removeData method. This will remove all elements in the allFlights ArrayList found in removeItems
        removeData(allFlights, removeItems);

        //Write information from allFlights ArrayList to outputFile
        writeOutData(allFlights, outputFile);
    }

    public static ArrayList<Flight> parseData(File inputFile){
        //Create scanner object
        Scanner in = null;
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Create array of flight objects
        ArrayList<Flight> results = new ArrayList<>();

        //Read input
        String year;
        String startCity;
        String endCity;
        double price;
        int distance;

        //Extract every line from the text file as a string then make an array filled with elements separated by ";"
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] tokens = line.split(";");

            //Skip to next line if the first word of the line is "year"
            if (!tokens[0].equalsIgnoreCase("year")) {
                year = tokens[0];
                startCity = tokens[1];
                endCity = tokens[2];
                //if token[3] is a negative number or if it is not a valid input, price will be set to 0
                try{
                    price = Double.parseDouble(tokens[3]);
                    if (price < 0){
                        price = 0.0;
                    }
                } catch (NumberFormatException e){
                    price = 0.0;
                }
                //if token[4] is a negative number or of it is not a valid input, distance will be set to 0
                try{
                    distance = Integer.parseInt(tokens[4]);
                    if (distance < 0){
                        distance = 0;
                    }
                } catch (NumberFormatException e){
                    distance = 0;
                }

                //Create Flight object from above information and add to ArrayList
                results.add(new Flight(year, startCity, endCity, price, distance));
            }
        }

        return results;
    }

    public static void removeData(ArrayList<Flight> allFlights, ArrayList<Flight> removeItems){
        for (int i = 0; i < allFlights.size(); i++){
            for (Flight removeItem : removeItems) {
                if (allFlights.get(i).equals(removeItem)) {
                    allFlights.remove(i);
                }
            }
        }
    }

    public static Flight calcBestFare(ArrayList<Flight> allFlights){
        //declare and initialize variables that will be used
        Flight bestFare = new Flight();
        double lowestFare = -1;

        //lowest-priced flight will be stored as bestFare
        for (Flight allFlight : allFlights) {
            if (lowestFare == -1 || allFlight.getPrice() < lowestFare) {
                lowestFare = allFlight.getPrice();
                bestFare = allFlight;
            }
        }

        return bestFare;
    }

    public static Flight calcBestFarePerMile(ArrayList<Flight> allFlights){
        //declare and initialize variables that will be used
        Flight bestFarePerMile = new Flight();
        ArrayList<Double> farePerMile = new ArrayList<Double>();
        double lowestFarePerMile = -1;

        //Calculate FarePerMile value for each flight
        for (Flight allFlight : allFlights) {
            farePerMile.add(allFlight.getPrice() / allFlight.getDistance());
        }

        //find flight with lowest FarePerMile and store to bestFarePerMile
        for (int i = 0; i < farePerMile.size(); i++){
            if (lowestFarePerMile == -1 || farePerMile.get(i) < lowestFarePerMile){
                lowestFarePerMile = farePerMile.get(i);
                bestFarePerMile = allFlights.get(i);
            }
        }

        return bestFarePerMile;
    }

    public static void writeOutData(ArrayList<Flight> allFlights, File outputFile){
        PrintWriter out = null;
        try {
            out = new PrintWriter(outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Incorrect output filename");
        }

        for (Flight allFlight : allFlights) {
            assert out != null;
            out.println(allFlight.getYear() + " " + allFlight.getStartCity() + " " + allFlight.getEndCity() + " " + allFlight.getPrice() + " " + allFlight.getDistance());
        }
        assert out != null;
        out.close();
    }
}