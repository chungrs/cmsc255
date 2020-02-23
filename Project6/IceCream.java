 /*********************************************************
 * Programming Project 6 - Ice Cream Shop - Ice Cream     *
 * ------------------------------------------------------ *
 * Mal's Ice Cream Shop sells ice cream and sundaes. They *
 * need a system to keep track of customers' purchases.   *
 * The shop needs some abstraction to keep track of their *
 * customers and the ice cream that those customers       *
 * purchase. This is the Ice Cream class that keeps track *
 * of the specific attributes of each ice cream ordered.  *
 * ------------------------------------------------------ *
 * Roy Chung                                              *
 * 20191102                                               *
 * CMSC 255 Section 1                                     *
 *********************************************************/

package Project6;

public class IceCream {
    private Size size;
    private Flavor flavor;
    private Sauce sauce;
    private Topping topping;
    private ToppingSun toppingSun;

    //default constructor
    public IceCream(){
        size = Size.SINGLE;
        flavor = Flavor.VANILLA;
        sauce = Sauce.NONE;
        topping = Topping.NONE;
        toppingSun = ToppingSun.NONE;
    }

    //custom constructor
    public IceCream(Size aSize){
        size = aSize;
        flavor = Flavor.VANILLA;
        sauce = Sauce.NONE;
        topping = Topping.NONE;
        toppingSun = ToppingSun.NONE;
    }

    //setters
    public void setSize(Size aSize){
        size = aSize;
    }
    public void setFlavor(Flavor aFlavor){
        flavor = aFlavor;
    }
    public void setSauce(Sauce aSauce){
        sauce = aSauce;
    }
    public void setTopping(Topping aTopping){
        topping = aTopping;
    }
    public void setToppingSun(ToppingSun aToppingSun){
        toppingSun = aToppingSun;
    }

    //getters
    public Size getSize(){
        return size;
    }
    public Flavor getFlavor(){
        return flavor;
    }
    public Sauce getSauce(){
        return sauce;
    }
    public Topping getTopping(){
        return topping;
    }
    public ToppingSun getToppingSun(){
        return toppingSun;
    }

    //return ice cream as string
    public String toString(){
        return "\n\t" + size + "\n\t" + flavor + "\n\t" + sauce + "\n\t" + topping + "\n\t" + toppingSun +"\n";
    }
}