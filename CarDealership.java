/* Programmer: Alliyah Mohammed */

//Import classes
import java.util.ArrayList;
import java.util.Comparator; 
import java.util.Collections; 
import java.util.Random;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/** 
 * class CarDealership is used to create the dealership and implement
 * various method for sorting and displaying the cars in inventory 
 */

public class CarDealership 
{

    //Instance Variables
    private ArrayList<Car> cars;
    private ArrayList<Transaction> transactions;
    private SalesTeam dealerTeam = new SalesTeam();
    private AccountingSystem dealerAS = new AccountingSystem();
    private double minPrice;
    private double maxPrice;
    private boolean electric;
    private boolean AWD;
    private boolean price;
    private int totalCarsSold;
    private int totalCarsRet; 
    private Random rand = new Random();
    private Car removed;
    

    /**
     * Constructor method that initializes the array list to an
     * empty array 
     */
    public CarDealership()
    {
        cars = new ArrayList<Car>();
	transactions = new ArrayList<Transaction>();
    }

    /**
     * Method that adds new cars from an array list into the car dealership
     * @param newCars the array list of cars to be added 
     */
    public void addCars(ArrayList<Car> newCars)
    {
        int s = newCars.size();

        for(int i = 0; i < s; i++)
        {
            cars.add(newCars.get(i));

        }
    }

    /**
     * Method to purchase a car from the dealership inventory after checking for
     * a valid array of cars and valid VIN 
     * @param VIN the VIN of the car within the dealership 
     * @return a receipt of the transaction
     */
    public String buyCar(int VIN)
    {
        //No cars in dealership - throw exception
        if(cars.size() == 0)
        {
            throw new IndexOutOfBoundsException("The dealer currently has no cars!\n"); 
        }

        //Invalid VIN - throw exception
        if((VIN < 100 || VIN > 499))
        {
            throw new IndexOutOfBoundsException("The VIN you entered is not valid!\n");
        }

        //Dealership has cars and chosen VIN is valid
        if(cars.size() > 0 && (VIN >= 100 && VIN <= 499))
        {
            
            for(int i = 0; i < cars.size(); i++)
            {
                Car c = cars.get(i);

                if(VIN == c.getVIN())
                {
                    removed = c;
                    cars.remove(c);
                }

                
            }
        
            String salesP = dealerTeam.getSalesPerson();
            int month = rand.nextInt(12);
            int day = rand.nextInt(14) + 1;

            Calendar calendar = new GregorianCalendar(2019, month, day);

            totalCarsSold++;

            return dealerAS.add(calendar,removed, salesP, "BUY", removed.getPrice());

            
        }

        //Return an empty string if no such car could be found 
        return "";
        
    }


    /**
     * Method to get the total number of cars bought from the dealer
     * @return number of buys
     */
    public int getTotalBuys()
    {
        return totalCarsSold;
    }

    /**
     * Method to get the total number of cars returned to the dealer
     * @return number of cars returned 
     */
    public int getTotalRet()
    {
        return totalCarsRet;
    }

    /**
     * Method to get the dealership Accounting System object
     * @return the dealership Accounting System object
     */
    public AccountingSystem getAS()
    {
        return dealerAS;
    }
    

    /**
     * Method to return a car to the dealer based on the transation of the purchase
     * @param trans is the transaction ID of the car to be returned 
     */
    public void returnCar(int trans)
    {

        transactions.add(dealerAS.getTransaction(trans));

        //Check for invalid input
        if(transactions.size() == 0 && dealerAS.numberOfTrans() == 0)
        {
            throw new IllegalStateException();
        }

        if(transactions.size() == 0)
        {
            throw new NullPointerException();
        }

        Transaction retT = dealerAS.getTransaction(trans);
        Car retCar = retT.getCar();

        

        ArrayList<Transaction> allTrans = new ArrayList<Transaction>(dealerAS.getAllTrans());

        //Counters for transactions(BUY and RET)
        int r = 0;
        int b = 0;

        //Check that this car has not already been returned by comparing the number of returns and buys
        for(int i = 0; i < allTrans.size(); i++)
        {
            Transaction t = allTrans.get(i);
            
            if(t.getCar() == retCar && t.getType().equals("RET"))
            {
                r++;
            }

            if(t.getCar() == retCar && t.getType().equals("BUY"))
            {
                b++;
            }

            if(b == r)
            {
                break;
            }


        } 

        String type = retT.getType();
        
        if(type.equals("BUY"))
        {

            int returnDay = rand.nextInt(17) + 15;

            Calendar newDate = retT.getCalendar();

            newDate.set(Calendar.DAY_OF_MONTH, returnDay);

            dealerAS.add(newDate, retT.getCar(), retT.getSP(), "RET", retT.getPrice());

            cars.add(retT.getCar());
            
            totalCarsRet++;
		
	    retT.setType("RET");



        }

	System.out.println("Car being RETURNED: " + retT.display() + "\n");


    
    }

    /**
     * Method that turns on the electric car filter 
     */
    public void filterByElectric()
    {
        electric = true;
    }

    /**
     * Method that turns on the AWD filter 
     */
    public void filterByAWD()
    {
        AWD = true; 
    }

    /**
     * Method that turns on the price filter, and sets the price range
     * @param minPrice the minimum price of the car
     * @param maxPrice the maximum price of the car 
     */
    public void filterByPrice(double minPrice, double maxPrice)
    {
        price = true;

        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        
    }

    /**
     * Method that clears all filters by setting their
     * boolean values to false
     */
    public void filtersClear()
    {
        price = false;
        AWD = false;
        electric = false;

    }

    /**
     * Method that displays all the cars in the dealership inventory if all filters are turned off. Otherwise,
     * inventory is displayed based on the filters that are set. 
     */
    public void displayInventory()
    {
        for(int i = 0; i < cars.size(); i++)
        {
            Car car = cars.get(i);

            if(price)
            {
                if((car.getPrice() <  minPrice) || (car.getPrice() > maxPrice))
                {
                    continue;
                }
            }

            if(electric && (car.getPower().equals("GAS_ENGINE")))
            {
                continue;
            }

            if(AWD && (car.getAWD() == false))
            {
                continue;
            }


            System.out.println(car.display());
        }

    }

    /**
     * Method used to sort the dealership inventory by price 
     */
    public void sortByPrice()
    {
        Collections.sort(cars);
    }

    /**
     * inner class that impliments the Comparator interface, used 
     * to create a compare method to compare two cars by price
     */
    class sortSR implements Comparator<Car>
    {
        /**
         * Method that compares two car objects based on their safety rating
         * @param a the first car object
         * @param b the second car object
         * @return the comparison value 
         */
        public int compare(Car a, Car b)
        {
            if(a.getSafetyRating() > b.getSafetyRating()) return -1;

            else if(a.getSafetyRating() < b.getSafetyRating()) return 1;

            else return 0;
        }
    }

    /**
     * Method that sorts the dealership inventory based on the safety rating
     * of each car 
     */
    public void sortBySafetyRating()
    {
        Collections.sort(cars, new sortSR());
    }

    /**
     * inner class that impliments the Comparator interface, used 
     * to create a compare method to compare two cars by max range
     */
    class sortMR implements Comparator<Car>
    {
        /**
         * Method that compares two car objects based on their max range
         * @param a the first car object
         * @param b the second car object
         * @return the comparison value 
         */
        public int compare(Car a, Car b)
        {
            if(a.getMaxRange() > b.getMaxRange()) return -1;

            else if(a.getMaxRange() < b.getMaxRange()) return 1;

            else return 0;
        }
    }

    /**
     * Method to sort the dealership inventory by max range 
     */
    public void sortByMaxRange()
    {
        Collections.sort(cars, new sortMR());
    }


}


