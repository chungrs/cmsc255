 /*********************************************************
 * Programming Project 5 - Travel Distances               *
 * ------------------------------------------------------ *
 * This program receives two strings from the command     *
 * line, one containing city abbreviations and the other  *
 * containing distances between all of the cities. A two- *
 * dimensional array is created from this information,    *
 * and using this information, then the program asks if   *
 * the user would like to search for cities within or     *
 * without a specified distance, asks for the distance,   *
 * then asks for the city of departure. The program then  *
 * returns the cities that fit the user's search criteria.*
 * ------------------------------------------------------ *
 * Roy Chung                                              *
 * 20191022                                               *
 * CMSC 255 Section 1                                     *
 *********************************************************/

package Project5;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class TravelDistances{
    public static void main(String[] args){
        //Store string from command line into two strings, one for cities and the other for distances
        String inputCityString = args[0];
        String inputDistanceString = args[1];

        //Pass aforementioned strings into the getCity and getDistance methods to return arrays
        String[] cities = getCity(inputCityString);
        int[][] distances = getDistance(inputDistanceString);

        //Create Scanner object
        Scanner in = new Scanner(System.in);

        //Print table
        System.out.print("    ");
        //Cities - column
        for(int i = 0; i < cities.length; i++){
            System.out.printf("%4s ", cities[i]);
        }

        for(int i = 0; i < distances.length; i++){
            //Cities - rows
            System.out.print("\n" + cities[i] + " ");
            for(int j = 0; j < distances[0].length; j++){
                //Print distances
                System.out.printf("%4s ", distances[i][j]);
            }
        }
        System.out.println("\n");

        //Prompt user for search parameters
        System.out.println("Type \"true\" if you would like to search for cities above a certain distance or \"false\" if you would like to search for cities below a certain distance: ");
        boolean isOver = in.nextBoolean();

        System.out.println("Enter the distance: ");
        int aDistance = in.nextInt();
        in.nextLine();

        System.out.println("Enter your departure city: ");
        String aCity = in.nextLine().trim();

        //Close scanner
        in.close();

        //Send user inputs to searchDistance
        String[] results = searchDistance(distances, cities, isOver, aDistance, aCity);
        System.out.println(Arrays.toString(results));
    }

    public static String[] getCity(String inputCityString){
        //Split string at every instance of "," and store them as separate elements within the array
        String[] city = inputCityString.split(",");
        return city;
    }

    public static int[][] getDistance(String inputDistanceString){
        //Split string at every instance of "<>" and store them as separate elements within the array.
        String[] rows = inputDistanceString.split("<>");

        //Create 2D array from the 1D array above by further splitting the strings - this time at every instance of "i"
        String distanceString[][] = new String[rows.length][];

        for (int i = 0; i < distanceString.length; i++){
            distanceString[i] = rows[i].split(",");
        }

        //convert String array into an int array
        int distance[][] = new int[distanceString[0].length][distanceString.length];

        for (int i = 0; i < distanceString.length; i++){
            for (int j = 0; j < distanceString.length; j++){
                distance[i][j] = Integer.parseInt(distanceString[i][j]);
            }
        }
        return distance;
    }

    public static String[] searchDistance(int[][] distances, String[] cities, boolean isOver, int aDistance, String aCity){
        //this index number will be used to look up distances in the distances array
        int departureCityIndex = -1;

        //See if aCity is in the array. If so, store its array index
        for(int i = 0; i < cities.length; i++){
            if(aCity.equalsIgnoreCase(cities[i])){
                departureCityIndex = i;
            }
        }

        //create ArrayList for the array indices of the cities
        ArrayList<Integer> resultIndex = new ArrayList<Integer>();

        //look for cities above or below aDistance, depending on whether the user entered true or false. Exclude departure city.
        for(int i = 0; i < distances[departureCityIndex].length; i++){
            //If condition for isOver
            if (isOver && distances[departureCityIndex][i] >= aDistance && distances[departureCityIndex][i] != 0){
                resultIndex.add(i);
            }
            //If condition for !isOver
            if (!isOver && distances[departureCityIndex][i] < aDistance && distances[departureCityIndex][i] != 0){
                resultIndex.add(i);
            }
        }

        //Create string for results and fill it up by looking up the indices found above.
        String[] results = new String[resultIndex.size()];
        for (int i = 0; i < resultIndex.size(); i++){
            results[i] = cities[resultIndex.get(i)];
        }

        //Alphabetize results string.
        Arrays.sort(results);

        return results;

    }
}