 /*********************************************************
 * Programming Project 6 - Ice Cream Shop - Customer      *
 * ------------------------------------------------------ *
 * Mal's Ice Cream Shop sells ice cream and sundaes. They *
 * need a system to keep track of customers' purchases.   *
 * The shop needs some abstraction to keep track of their *
 * customers and the ice cream that those customers       *
 * purchase. This is the Customer class that keeps track  *
 * of the information and orders of customers.            *
 * ------------------------------------------------------ *
 * Roy Chung                                              *
 * 20191102                                               *
 * CMSC 255 Section 1                                     *
 *********************************************************/

package Project6;

import java.util.ArrayList;

public class Customer {
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private ArrayList<IceCream> iceCream = new ArrayList<IceCream>();

    //default constructor
    public Customer(){
        //all values set to null, arraylist remains empty
    }

    //custom constructor
    public Customer(String aLastName, String aFirstName, String aPhone, String anEmail) {
        lastName = aLastName;
        firstName = aFirstName;
        phone = aPhone;
        email = anEmail;
    }
    //setters
    public void setLastName(String aLastName){
        lastName = aLastName;
    }
    public void setFirstName(String aFirstName){
        firstName = aFirstName;
    }
    public void setPhone(String aPhone){
        phone = aPhone;
    }
    public void setEmail(String anEmail){
        email = anEmail;
    }

    //getters
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }

    //add IceCream object to the Customer object
    public void orderIceCream(IceCream anIceCream) {
        iceCream.add(anIceCream);
    }

    //return number of ice creams in a particular order
    public int getNumIceCream(){
        return iceCream.size();
    }

    //return ArrayList of IceCreams associated with Customer object
    public ArrayList<IceCream> getIceCream(){
        return iceCream;
    }

    //return order as string
    @Override
    public String toString(){
        //orderList will have the customer's information as well as the ice cream ordered in a formatted list
        String orderList = firstName + " " + lastName + "\n" + phone + "\n" + email + "\nIce Cream Order:\n";

        //for loop adds each ice cream ordered to the orderList string by using the toString method from the IceCream class.
        for (IceCream anIceCream : iceCream){
            orderList += anIceCream.toString();
        }

        return orderList;
    }
}