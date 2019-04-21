/* Programmer: Alliyah Mohammed */

//Import class
import java.util.Random; 

/**
 * class Vehicle that creates a Vehicle object and 
 * contains getter and setter methods
 */

public class Vehicle
{
    //Instance variables 
    private String mfr;
    private String color;
    private String power;
    private int numWheels;
    private int VIN; 

    //Public constant variables 
    public static final int GAS_ENGINE = 0;
    public static final int ELECTRIC_MOTOR = 1;

    //Create a random object to use for generating a random number
    Random rand = new Random();
    

    /**
     * constructor method to initializle instance varaibles 
     * @param mfr the vehicle manufacturer 
     * @param color the color of the vehicle 
     * @param power the type of power supply the vehicle uses 
     * @param numWheels the number of wheels the vehicle has
     */
    public Vehicle(String mfr, String color, String power, int numWheels)
    {
        this.mfr = mfr;
        this.color = color;
        this.power = power;
        this.numWheels = numWheels; 
        this.VIN = rand.nextInt(400) + 100; //generates random number from 100 - 499
    }

    /**
     * Method that gets the manufacturer of the vehicle 
     * @return vehicle manufacturer
     */

    public String getMfr()
    {
        return mfr;
    
    }

    /**
     * Method that sets the vehicle manufacturer 
     * @param newMfr manufacturer to be set
     */
    public void setMfr(String newMfr)
    {
        this.mfr = newMfr;
    }


    /**
     * Method that sets the color of the vehicle
     * @return color of vehicle
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Method that gets the color of the vehicle 
     * @param newColor the color of the vehicle
     */
    public void setColor(String newColor)
    {
        this.color = newColor;
    }

    /**
     * Method that gets the power of the vehicle
     * @return power of vehicle
     */
    public String getPower()
    {
        return power;
    }

    /**
     * Method that sets the power of the vehicle 
     * @param newPower of vehicle to be set 
     */
    public void setPower(String newPower)
    {
        this.power = newPower;
    }

    /**
     * Method that gets the number of wheels of the vehicle
     * @return number of wheels of the vehicle
     */
    public int getNumWheels()
    {
        return numWheels;
    }

    /**
     * Method that sets the number of wheels of the vehicle 
     * @param newNumWheels the number of wheels of the vehicle
     */
    public void setNumWheels(int newNumWheels)
    {
        this.numWheels = newNumWheels;
    }

    /**
     * Method to get the VIN of the car 
     * @return the VIN of the car
     */
    public int getVIN()
    {
        return VIN;
    }

    /**
     * Method that comapres two vehicle objects based on their 
     * manufacturer, power, and number of wheels in order to 
     * determine if they are equal. 
     * @param other the other object that this object gets compared to 
     * @return whether or not the objects are equal
     */
    public boolean equals(Object other)
    {
        Vehicle otherVehicle = (Vehicle) other;

        return mfr.equals(otherVehicle.mfr) && power == otherVehicle.power && numWheels == otherVehicle.numWheels;

    }

    /**
     * Method that displays a string representation of the vehicle object 
     * @return string representation of the vehicle object 
     */
    public String display()
    {
        return "VIN: " + VIN + " | " + mfr + " | " + color;
    }


}
