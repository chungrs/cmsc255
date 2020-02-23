/******************************************************
* Programming Project 4 - Temperature Conversions
*******************************************************
* This program converts temperature values between the
* three temperature scales: Celsius, Fahrenheit, and 
* Kelvin.
*______________________________________________________
* Roy Chung
* 20191007
* CMSC 255 Section 1
*******************************************************/
import java.util.Scanner;

public class TempConvert{
    public static void main(String[] args) {
        //call processData to run the conversion
        processData();
    }

    public static void processData(){
        //loopOn will be used to either continue or end the loop, depending on user input.
        boolean loopOn = true;

        //Initialize Scanner
        Scanner input = new Scanner(System.in);

        while (loopOn) {
            //Prompt user for temperature
            System.out.println("Enter the temperature to convert:");
            double temp = input.nextDouble();

            //Empty nextLine is here to "absorb" the /n from the previous input.
            input.nextLine();

            //Prompt user for current scale
            System.out.println("Enter the current scale of the temperature:");
            String scale = input.nextLine();

            //Prompt user for target scale
            System.out.println("Enter the scale you want to convert the temperature to:");
            String targetScale = input.nextLine();

            //If checkValidity returns a true value, then one of the six conversion methods will be called to run the conversion if current and target scales differ
            if (checkValidity(temp, scale)){
                //If current and target scales are the same, no method is called
                if (scale.equalsIgnoreCase(targetScale)){
                    System.out.printf("%.2f degrees " + scale + " is %.2f degrees " + scale +"\n", temp, temp);
                }
                //Different methods are called depending on current and target scales
                else if(scale.equalsIgnoreCase("fahrenheit") && targetScale.equalsIgnoreCase("celsius")){
                    System.out.printf("%.2f degrees Fahrenheit is %.2f degrees Celsius\n", temp, convertFahtoCel(temp));
                }
                else if (scale.equalsIgnoreCase("fahrenheit") && targetScale.equalsIgnoreCase("kelvin")){
                    System.out.printf("%.2f degrees Fahrenheit is %.2f degrees Kelvin\n", temp, convertFahtoKel(temp));
                }
                else if (scale.equalsIgnoreCase("celsius") && targetScale.equalsIgnoreCase("fahrenheit")){
                    System.out.printf("%.2f degrees Celsius is %.2f degrees Fahrenheit\n", temp, convertCeltoFah(temp));
                }
                else if (scale.equalsIgnoreCase("celsius") && targetScale.equalsIgnoreCase("kelvin")){
                    System.out.printf("%.2f degrees Celsius is %.2f degrees Kelvin\n", temp, convertCeltoKel(temp));
                }
                else if (scale.equalsIgnoreCase("kelvin") && targetScale.equalsIgnoreCase("celsius")){
                    System.out.printf("%.2f degrees Kelvin is %.2f degrees Celsius\n", temp, convertKeltoCel(temp));
                }
                else if (scale.equalsIgnoreCase("kelvin") && targetScale.equalsIgnoreCase("fahrenheit")){
                    System.out.printf("%.2f degrees Kelvin is %.2f degrees Fahrenheit\n", temp, convertKeltoFah(temp));
                }
                else {
                    System.out.println("Invalid input.");
                }
                
            }
            else { //condition if checkValidity returns a false value
                System.out.println(temp + " degrees " + scale.toUpperCase().charAt(0) +  scale.substring(1) + " is not a valid temperature");
            }

            //Ask if user wishes to perform another temperature conversion
            System.out.println("Would you like to convert another temperature? Enter quit to exit.");
            String anotherOne = input.nextLine().trim();

            //Set loopOn to false if user does not wish to create another sign, ending the loop.
            if (anotherOne.equalsIgnoreCase("quit") || anotherOne.equalsIgnoreCase("no") || anotherOne.equalsIgnoreCase("exit")){
                loopOn = false;
            }

        }
        //Close scanner
        input.close();
    }

    public static boolean checkValidity(double temp, String scale){
        //initialize and declare boolean value
        boolean valid;
        final double MAX_TEMP = 1000;

        //Conditions that must be met for valid to return true, anything outside of these parameters will return false and processData will return an error message.
        if (scale.equalsIgnoreCase("fahrenheit") && temp >= -459.40 && temp <= MAX_TEMP){
            valid = true;
        }
        else if (scale.equalsIgnoreCase("celsius") && temp >= -273 && temp <= MAX_TEMP){
            valid = true;
        }
        else if (scale.equalsIgnoreCase("kelvin") && temp >= 0 && temp <= MAX_TEMP){
            valid = true;
        }
        else{
            valid = false;
        }

        return valid;
    }

    //Method for Fahrenheit to Celsius conversion
    public static double convertFahtoCel(double temp){
        return ((temp - 32) * 5) / 9;
    }

    //Method for Fahrenheit to Kelvin conversion
    public static double convertFahtoKel(double temp){
        return ((temp - 32) * 5) / 9 + 273;
    }

    //Method for Celsius to Fahrenheit conversion
    public static double convertCeltoFah(double temp){
        return (temp * 9/5) + 32;
    }

    //Method for Celsius to Kelvin conversion
    public static double convertCeltoKel(double temp){
        return temp + 273;
    }
    
    //Method for Kelvin to Celsius conversion
    public static double convertKeltoCel(double temp){
        return temp - 273;
    }

    //Method for Kelvin to Fahrenheit conversion
    public static double convertKeltoFah(double temp){
        return ((temp - 273) * 9/5) + 32;
    }
}