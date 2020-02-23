package Project7;

public class Flight {
    //instance variables
    private String year;
    private String startCity;
    private String endCity;
    private double price;
    private int distance;

    //default constructor
    public Flight(){
        year = "1970";
        startCity = "Boston";
        endCity = "Richmond";
        price = 40.0;
        distance = 900;
    }

    //parameterized constructor
    public Flight(String year, String startCity, String endCity, double price, int distance){
        this.year = year;
        this.startCity = startCity;
        this.endCity = endCity;
        this.price = price;
        this.distance = distance;
    }

    //getters
    public String getYear() {
        return year;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public double getPrice() {
        return price;
    }

    public int getDistance() {
        return distance;
    }

    //setters
    public void setYear(String year) {
        this.year = year;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    //return Flight info as string
    public String toString(){
        return year + " " + startCity + " " + endCity + " " + price + " " + distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Flight) {
            Flight p = (Flight) obj;
            return this.year.equals(p.year) && this.startCity.equals(p.startCity) && this.endCity.equals(p.endCity) && this.price == p.price && this.distance == p.distance;
        }
        return false;
    }
}
