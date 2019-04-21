/* Programmer: Alliyah Mohammed */

//Import classes
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * class Transaction creates a transaction object that records all the
 * appropriate information of a BUY or RET transaction. It contains
 * various getter and setter methods to get access to this information,
 * as well as a display function to print the transaction. 
 */
public class Transaction
{
    //Instance variables 
    private int ID;
    private Calendar calendar;
    private Car car;
    private String salesPerson;
    private String transType;
    private double price;


    /**
     * Constructor method to initialize all the instance varibles for the transaction class
     * @param id the transaction ID
     * @param c the calendar used for the transaction date
     * @param transCar the car object representing the car used in the transaction
     * @param nameSP name of the sales person
     * @param type type of transaction ie. BUY or RET
     * @param price sale price of the car 
     */
    public Transaction(int id, Calendar c, Car transCar, String nameSP, String type, double price)
    {
        this.ID = id;
        this.calendar = c;
        this.car = transCar;
        this.salesPerson = nameSP;
        this.transType = type;
        this.price = price;
        
    }

    /**
     * Method to get the transaction ID 
     * @return the transaction ID
     */
    public int getID()
    {
        return ID; 
    }

    /**
     * Method to get the calendar object associated with the transaction 
     * @return the calendar object
     */
    public Calendar getCalendar()
    {
        return calendar;
    }
    
    /**
     * Method to get the car object associated with the transaction 
     * @return the car object
     */
    public Car getCar()
    {
        return this.car;
    
    }
    
    /**
     * Method to get the sales person for this transaction
     * @return the name of the sales person
     */
    public String getSP()
    {
        return salesPerson;
    }
    
    /**
     * Method to get the type of transaction (BUY/RET)
     * @return the type of transaction
     */
    public String getType()
    {
        return transType;
    }

    /**
     * Method to get the price of the car from the transaction
     * @return the price of the car
     */
    public double getPrice()
    {
        return price; 
    }
    
    
    /**
     * Method to return a string display of a transaction 
     * @return the string representation of the transaction
     */
    public String display()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM dd, yyyy");

        return "ID: " + ID + " | " + sdf.format(calendar.getTime()) + " | " + transType + " | SalesPerson: " + salesPerson + " | Car: " + car.display(); 
    }




    
}
