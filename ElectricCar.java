/* Programmer: Alliyah Mohammed */

/**
 * class ElectricCar extends class Car, so it inherits all the 
 * instance variables of Car but adds the instance variables
 * to hold the type of battery the car uses, as well as the
 * recharge time. 
 */ 

public class ElectricCar extends Car
{
    //Instance variables 
    private int rechargeTime; //holds recharge time in MINUTES 
    private String batteryType;

    

    /**
     * constructor method to initialize declared and inherited instance variables
     * @param mfr the manufacturer of the car
     * @param color the color of the car
     * @param model the model of the car
     * @param power the power type of the car
     * @param safetyRating the safety rating of the car 
     * @param maxRange the max range of the car 
     * @param AWD booleam to hold whether or not the car ia all wheel drive 
     * @param price the price of the car 
     * @param numWheels the number of wheels the car has 
     * @param rechargeTime the time it takes for the car to recharge
     * @param batteryType the battery type used in the car 
     */
        public ElectricCar(String mfr, String color, String model, String power, double safetyRating, int maxRange, boolean AWD, double price, int numWheels, int rechargeTime, String batteryType)
     {
        super(mfr, color, model, power, safetyRating, maxRange, AWD, price, numWheels);
        this.rechargeTime = rechargeTime;
        this.batteryType = batteryType; 
     }


    /**
     * Method that gets the recharge time of the electric car 
     * @return the recharge time of the electric car 
     */
    public int getRechargeTime()
    {
        return rechargeTime;
    }

    /**
     * Method that sets the recharge time of the electric car 
     * @param rT the recharge time of the electric car 
     */
    public void setRechargeTime(int rT)
    {
        rechargeTime = rT;
    }

    /**
     * Method that gets the battery type of the electric car 
     * @return the battery type of the electric car 
     */
    public String getBatteryType()
    {
        return batteryType;
    }

    /**
     * Method that sets the battery type of the electric car 
     * @param bT the battery type of the vehicle
     */
    public void setBatteryType(String bT)
    {
        batteryType = bT;
    }

    /**
     * Method that displays a string representation of the electric car object 
     * @return string representation of the electric car 
     */
    public String display()
    {
        return super.display() + " EL, BAT: " + batteryType + " RCH: " + rechargeTime;
    } 

}
