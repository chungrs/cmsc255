package Project6;

public class IceCreamShop {
    public static void main(String[] args) {
        //Create customers
        Customer customer1 = new Customer("Budwell", "Caroline", "804-937-8111", "ccbudwell@vcu.edu");
        Customer customer2 = new Customer("Whitten", "Zachary", "555-222-1111", "zwhitten@vcu.edu");

        //Create Ice Cream 1
        IceCream iceCream1 = new IceCream(Size.DOUBLE);
        iceCream1.setFlavor(Flavor.ROCKY_ROAD);
        iceCream1.setSauce(Sauce.STRAWBERRY);
        iceCream1.setTopping(Topping.CHOCOLATE_FLAKES);
        //Create Ice Cream 2
        IceCream iceCream2 = new IceCream(Size.SUNDAE);
        iceCream2.setFlavor(Flavor.VANILLA);
        iceCream2.setSauce(Sauce.HOT_FUDGE);
        iceCream2.setTopping(Topping.SPRINKLES);
        iceCream2.setToppingSun(ToppingSun.WHIPPED_CREAM_AND_CHERRY);

        //Attribute Ice Creams 1 and 2 to Customer 1
        customer1.orderIceCream(iceCream1);
        customer1.orderIceCream(iceCream2);

        //Create Ice Cream 3
        IceCream iceCream3 = new IceCream(Size.SINGLE);
        iceCream3.setFlavor(Flavor.OREO);
        iceCream3.setTopping(Topping.CANDY);

        //Attribute ice cream 3 to customer 2
        customer2.orderIceCream(iceCream3);

        System.out.println(customer1.toString());

        System.out.println(customer2.toString());

    }


}