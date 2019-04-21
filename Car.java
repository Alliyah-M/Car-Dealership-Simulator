/* Programmer: Alliyah Mohammed */

/**
 * class Car is an extension of class Vehicle, inheriting the mfr, color,
 * power, and numWheels variables. This class also implements the comparable
 * interface which is used to compare car objects. 
 */

public class Car extends Vehicle implements Comparable<Car>
{
    //Instance Variables
    private String model;
    private int maxRange;
    private double safetyRating;
    private boolean AWD;
    private double price;

    //Public constant variables for model 
    public static final int SEDAN = 0;
    public static final int SUV = 1;
    public static final int SPORTS = 2;
    public static final int MINIVAN = 3;
     

    /**
     * Constructor method to initialize instance variables.
     * @param mfr the manufacturer of the car
     * @param color the color of the car
     * @param model the model of the car
     * @param power the power type of the car
     * @param safetyRating the safety rating of the car 
     * @param maxRange the max range of the car 
     * @param AWD booleam to hold whether or not the car ia all wheel drive 
     * @param price the price of the car 
     * @param numWheels the number of wheels the car has 
     */
    public Car(String mfr, String color, String model, String power, double safetyRating, int maxRange, boolean AWD, double price, int numWheels)
    {
       

        super(mfr, color, power, numWheels);
        this.model = model;
        this.maxRange = maxRange;
        this.safetyRating = safetyRating;
        this.AWD = AWD;
        this.price = price;

    }

   

    /**
     * Method that gets the model of the car 
     * @return the model of the car 
     */
    public String getModel()
    {
        return model;
    }

    /**
     * Method that sets the model of the car 
     * @param m the model of the car to be set 
     */
    public void setModel(String m)
    {
        model = m;
    }

    /**
     * Method that gets the max range of the car 
     * @return the max range of the car 
     */
    public int getMaxRange()
    {
        return maxRange;
    }

    /**
     * Method that sets the max range of the car 
     * @param max the max range of the car to be set 
     */
    public void setMaxRange(int max)
    {
        maxRange = max;
    }

    /**
     * Method that gets the safety rating of the car 
     * @return the safety rating of the car 
     */
    public double getSafetyRating()
    {
        return safetyRating;

    }

    /**
     * Method that sets the safety rating of the car
     * @param sR the safety rating of the car to be set 
     */
    public void setSafetyRating( double sR)
    {
        safetyRating = sR;
    }
    
    /**
     * Method that gets the AWD value for the car (true if it is AWD, false if not)
     * @return whether or not the car is AWD
     */
    public boolean getAWD()
    {
        return AWD;
    }

    /**
     * Method that sets the AWD value for the car 
     * @param a the boolean to represent if the car is AWD
     */
    public void setAWD(boolean a)
    {
        AWD = a;
    }
    
    /**
     * Method that gets the price of the car
     * @return the price of the car 
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * Method that sets the price of the car 
     * @param p the price of the car 
     */
    public void setPrice(double p)
    {
        price = p; 
    }

    /**
     * Displays a string representation of inherited as well as declared instance variables 
     * by using the super() call. Note that the if structure used is so that the integer
     * representation of the model variable can be represented as the appropriate string.
     * @return string representation of object 
     */
    public String display()
    {  
        return super.display() + " | " + model + " | $" + price + " | SF: " + safetyRating + " | RNG: " + maxRange;
    }

    /**
     * compares two objects to determine if they are equal 
     * @param other the object used for comparison 
     * @return boolean result of comparison 
     */
    public boolean equals(Object other)
    {
        //Cast other to a Car reference
        Car otherCar = (Car) other;

        if(super.equals(other) && this.model == otherCar.model && this.AWD == otherCar.AWD)
        {
            return true;
        }

        return false;
    }

    /**
     * compare two car objects based on their price using the inhereited 
     * Comparable interface.
     * @param other the other car object used for comparison 
     * @return integer representation of whether or not they are equal 
     */
    public int compareTo(Car other)
    {
        if(this.price > other.price)
        {
            return 1;
        }

        if(this.price < other.price)
        {
            return -1;
        }

        return 0; 
    }
    
}
