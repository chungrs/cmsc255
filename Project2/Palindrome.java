/**********************************************************
* Programming Project 2 - Palindrome
***********************************************************
* This program determines whether or not a three-digit
* integer, either randomly generated or entered by the
* user, generated or entered by the user, is a palindrome.
*__________________________________________________________
* Roy Chung
* 20190903
* CMSC 255 Section 1
***********************************************************/

import java.util.Scanner;

public class Palindrome {
    public static void main(String [] args){
		//Create scanner object
		Scanner input = new Scanner(System.in);
		
		//Prompt user to input option. Option 1 enables user to manually enter a three-digit number. Option 2 gets the program to generate a random three-digit number.
		System.out.println("Enter 1 if you would like to enter a 3-digit number. Enter 2 if you would like to have the computer generate it.");
		
		//Input is stored as variable option
		int option = input.nextInt();
		
		//threeDigitNumber declared outside of if statement so it can be used throughout the main method
		int threeDigitNumber;

		switch (option) {
			case 1: //Prompt user to enter three-digit number
				System.out.println("Enter the 3-digit number:");
				threeDigitNumber = input.nextInt();
				input.close();
				break;
			case 2: //Generate three-digit number. In other words, generate a number between 100 and 999 (inclusive)
				threeDigitNumber = ((int)(Math.random() * (999 - 100) + 100));
				System.out.println(threeDigitNumber);
				break;
			default: //Invalid Entry - user enters value other than 1 or 2
				System.out.println("Incorrect input");
				input.close();
				return;
		}
		
		//Invalid Entry - threeDigitNumber is greater than 999 or less than 100
		if (threeDigitNumber < 100 || threeDigitNumber > 999) {
			System.out.println("Incorrect input");
			return;
		}
		else {
			//threeDigitNumber divided by 100 with remainders removed gives us the value of the hundreds place
			int hundreds = threeDigitNumber / 100;
			
			//Determine the value of the tens and ones place
			int hundredsRemainder = threeDigitNumber % 100;
			
			//Determine the value of the ones place
			int ones = hundredsRemainder % 10;
			
			//If the hundreds place and the ones place are equal, then the three digit number is a palindrome.
			if (hundreds == ones) {
				System.out.println(threeDigitNumber + " is a palindrome");
			}
			//If the hundreds place and ones place do not equal one another, then we do not have a palindrome.
			else {
					System.out.println(threeDigitNumber + " is not a palindrome");
			}
		}
		
	}
}