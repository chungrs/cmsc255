/**********************************************************
* Programming Project 3 - Tri-Circle Sign
***********************************************************
* This program determines the price of a custom-made sign
* in the shape of a circle that surrounds a given
* equilateral triangle. The size of the circle, determined
* by the size of the triangle, and the number of characters
* are the determining factors of the price.
*__________________________________________________________
* Roy Chung
* 20190919
* CMSC 255 Section 1
***********************************************************/

import java.util.Scanner;

public class TriCircleSign {
    public static void main (String[] args){
        //loopOn will be used to either continue or end the loop, depending on user input.
        boolean loopOn = true;

        //Initialize and declare constants for sign price
        final double DOLLARS_PER_SQFT = 2.35;
        final double DOLLARS_PER_CHARARCTER = 1.45;

        //Create Scanner Object
        Scanner in = new Scanner(System.in);

        //Begin Loop Body
        while (loopOn) {
            
            //Ask user for desired sign size (by asking for the side length of equilateral triangle)
            System.out.println("Enter the length of a side of your triangle:");
            double sideLength = in.nextDouble();

            //Determine area given the side length
            double s = 3 * sideLength / 2;
            double radius = Math.pow(sideLength, 3) / (4 * Math.sqrt(s * Math.pow(s - sideLength, 3)));
            //Determine sign size portion of price
            double area = Math.PI * Math.pow(radius, 2);
            double priceSize = area * DOLLARS_PER_SQFT;
            
            //Empty nextLine is here to "absorb" the /n from the previous input.
            in.nextLine();
            //Ask user for desired sign message
            System.out.println("Enter the string you would like on your sign:");
            String signString = in.nextLine();
            //Determine message length portion of price
            int messageLength = signString.replace(" ", "").length();
            double priceMessage = messageLength * DOLLARS_PER_CHARARCTER;

            //add the size and message components of price to determine total price of sign
            double totalPrice = priceMessage + priceSize;

            //Output total price
            System.out.printf("%.2f%n", totalPrice);

            //Ask if user wishes to create another sign
            System.out.println("Would you like to create another sign? Enter quit to exit.");
            String anotherOne = in.nextLine().trim();

            //Set loopOn to false if user does not wish to create another sign, ending the loop.
            if (anotherOne.equalsIgnoreCase("quit") || anotherOne.equalsIgnoreCase("no") || anotherOne.equalsIgnoreCase("exit")){
                loopOn = false;
            }  
          }
          //End Loop Body
          //Close scanner
          in.close();
    }
}
