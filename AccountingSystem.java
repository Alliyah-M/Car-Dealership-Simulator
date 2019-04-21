/* Programmer: Alliyah Mohammed */

//Import classes 
import java.util.Random;
import java.util.Calendar;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

/**
 * the AccountingSystem calss creates an array list of transaction objects, 
 * and contains methods to add transactions as well as methods to get various
 * transaction related values. There are also two inner classes that create 
 * salesPerson and Month objects that create appropriate array lists that can be sorted.
 */
public class AccountingSystem
{
    //Instance Variables
    private int ID;
    private ArrayList<Transaction> transactions; 
    private double totalSalesYear;

    /**
     * contructor method to initialize the array list instance variable 
     */
    public AccountingSystem()
    {
        transactions = new ArrayList<Transaction>();
    }
    
    /**
     * Method that creates a new transaction and adds it to the array list of transactions
     * @param date the date of the transaction
     * @param car the car that was sold/bought during the transaction
     * @param salesPerson the name of the sales person
     * @param type the type of transaction ie. BUY vs RET
     * @param salePrice the sale price of the car 
     * @return a string representation of the transaction that was just made 
     */
    public String add(Calendar date, Car car, String salesPerson, String type, double  salePrice)
    {
        Random randID = new Random();

        ID = randID.nextInt(98) + 1;

        Transaction newTrans = new Transaction(ID, date, car, salesPerson, type, salePrice);

        transactions.add(newTrans);

        //Add the price of the car being bought to total sales
        if(type.equals("BUY"))
        {
            totalSalesYear += salePrice;
         
        }

        //Subtract the price of the car being returned from total sales
        if(type.equals("RET"))
        {
            totalSalesYear -= salePrice;
        }

        return newTrans.display();
    }


    /**
     * Method to return the desired transaction based on a given ID 
     * @param id the transaction ID of the desired transaction 
     * @return the transaction 
     */
    public Transaction getTransaction(int id)
    {
        for(int i = 0; i < transactions.size(); i++)
        {   
            Transaction t = transactions.get(i);
            int tempID = t.getID();

            if(id == tempID)
            {
                return t;
            }
        } 

        return null;
    }

    /**
     * Method to get the number of transactions
     * @return number of transactions 
     */
    public int numberOfTrans()
    {
        return transactions.size();
    }

    /**
     * Method to get the total sales for the year
     * @return the total sales for the year
     */
    public double getTSY()
    {
        return totalSalesYear;
    }

    /**
     * Method to get all the transactions for the year
     * @return the transactions for the year 
     */
    public ArrayList<Transaction> getAllTrans()
    {
        return transactions;
    }

    /**
     * Method to get the top salesPerson based on all transactions
     * @return the name of the top sales person 
     */
    public String topSalesPerson()
    {
        ArrayList<SP> topSales = new ArrayList<SP>();
        SP  charlesManson = new SP("Charles Manson");
        SP  tedBundy = new SP("Ted Bundy");
        SP  jeffreyDahmer = new SP("Jeffrey Dahmer");
        SP  johnGacy = new SP("John Gacy");
        SP  johnKramer = new SP("John Kramer");
        SP  henryHolmes = new SP("Henry Holmes");

        topSales.add(charlesManson);
        topSales.add(tedBundy);
        topSales.add(jeffreyDahmer);
        topSales.add(johnGacy);
        topSales.add(johnKramer);
        topSales.add(henryHolmes);


        //Check for who has had sales, and add them to the appropriate object in the list 
        for(int i = 0; i < transactions.size(); i++)
        {
            Transaction currentTrans = transactions.get(i);

            String salesPName = currentTrans.getSP();

            if(salesPName.equals("Charles Manson"))
            {
                charlesManson.addSale();
            }

            if(salesPName.equals("Ted Bundy"))
            {
                tedBundy.addSale();
            }

            if(salesPName.equals("Jeffrey Dahmer"))
            {
                jeffreyDahmer.addSale();
            }

            if(salesPName.equals("John Gacy"))
            {
                johnGacy.addSale();
            }

            if(salesPName.equals("John Kramer"))
            {
                johnKramer.addSale();
            }

            if(salesPName.equals("Henry Holmes"))
            {
                henryHolmes.addSale();
            }
        }

        //Sort sales persons
        Collections.sort(topSales);

        int sold = topSales.get(0).getSale();

        String topSP = topSales.get(0).getName() + " " + sold;

        //Check for any ties for top sales
        for(int i = 1; i < topSales.size(); i++)
        {
            SP other = topSales.get(i);

            if(other.getSale() == sold)
            {
                topSP += ", " + other.getName() + " " + other.getSale();
            }
        }

        return topSP;
    }
    
    /**
     * Method that returns all the sales for a given month
     * @param m the integer representation of the month (Jan = 0, Dec = 11)
     * @return an array list of all the transactions for the given month
     */
    public ArrayList<String> salesByMonth(int m)
    {
        ArrayList<String> transForMonth = new ArrayList<String>();

        for(Transaction t : transactions)
        {
            if(m == t.getCalendar().get(Calendar.MONTH))
            {
                transForMonth.add(t.display());
            }
        }

        return transForMonth;
    }

    /**
     * Method to determine which month had the top sales i.e, the most amount of cars sold 
     * @return String representation of the top month 
     */
    public String topSalesMonth()
    {
        ArrayList<Month> monthlySales = new ArrayList<Month>();

        monthlySales.add(new Month(0));
        monthlySales.add(new Month(1));
        monthlySales.add(new Month(2));
        monthlySales.add(new Month(3));
        monthlySales.add(new Month(4));
        monthlySales.add(new Month(5));
        monthlySales.add(new Month(6));
        monthlySales.add(new Month(7));
        monthlySales.add(new Month(8));
        monthlySales.add(new Month(9));
        monthlySales.add(new Month(10));
        monthlySales.add(new Month(11));

        for(int n = 0; n < transactions.size(); n++)
        {
            Transaction t = transactions.get(n);
           int m = t.getCalendar().get(Calendar.MONTH);

           for(int i = 0; i < 12; i++)
           {
               if((m == i) && (t.getType() == "BUY"))
               {
                   monthlySales.get(i).carSold();
               }
           }
        }

        //Sort monthly sales
        Collections.sort(monthlySales);


        //Hashmap for relating integer representation to the string name of the month 
        Map<Integer, String> monthMap = new HashMap<>();
		monthMap.put(0, "January");
		monthMap.put(1, "February");
		monthMap.put(2, "March");
		monthMap.put(3, "April");
		monthMap.put(4, "May");
	    monthMap.put(5, "June");
		monthMap.put(6, "July");
		monthMap.put(7, "August");
		monthMap.put(8, "September");
		monthMap.put(9, "October");
		monthMap.put(10, "November");
        monthMap.put(11, "December");

        Month topM = monthlySales.get(0);
        int top = topM.getMonth();
        int topSales = topM.getCS();
        String topMonth = monthMap.get(top) + ": cars sold - " + topSales;
        
        //Check for any ties
        for(int i =1; i < monthlySales.size(); i++)
        {
            Month tempMonth = monthlySales.get(i);
            int tempSales = tempMonth.getCS();
            if(tempSales == topSales)
            {
                topMonth += " ," + monthMap.get(tempMonth.getMonth()) + ": cars sold - " + tempSales;
            }

        } 
									 


        return topMonth;
    }
    
    
    /**
     * Inner class SP that creates a salesPerson object. 
     * This class also implements the Comparable class
     * in order to sort a collection of these objects. 
     */
    public class SP implements Comparable<SP>
    {
        //Instance variables
        private int sales;
        private String name;

        /**
         * Constructor method to initialize instance vairable sales
        */
        public SP(String name)
        {
            sales = 0;
            this.name = name;

        }

        /**
         * Method to get the name of the sales person associated with the object
         * @return name of the sales person
         */
        public String getName()
        {
            return name;
        }

        /**
        * Method to increment the number of sales for the sales person 
        */
        public void addSale()
        {
            sales++;
        }

        /**
         * Method to get the number of cars this sales person has sold
         * @return number of cars
         */
        public int getSale()
        {
            return sales;
        }

        /**
        * compare two sales person objects based on their sales using the inhereited 
        * Comparable interface.
        * @param other the other sales person object used for comparison 
        * @return integer representation of whether or not they are equal 
        */
        public int compareTo(SP other)
        {
            if(this.getSale()> other.getSale())
            {
                return -1;
            }

            if(this.getSale() < other.getSale())
            {
            return 1;
            }

            return 0; 
        }

    }

     /**
     * Inner class Month that creates a month object. 
     * This class also implements the Comparable class
     * in order to sort a collection of these objects. 
     */
    public class Month implements Comparable<Month>
    {
        //Instance variables
        private int carsSold;
        private int month;

        /**
         * Constructor method to initialize instance variable carsSold
         */
        public Month(int month)
        {
            carsSold = 0;
            this.month = month;
        }

        /**
         * Method to increment numbers of cars sold within the month
         */
        public void carSold()
        {
            carsSold++;
        }

        /**
         * Method to get the total number of cars sold in top month
         * @return total number of cars
         */
        public int getCS()
        {
            return carsSold;
        }

        /**
         * Method to get the month 
         * @return the integer value of the month (0 == January)
         */
        public int getMonth()
        {
            return month;
        }

        /**
        * compare two Month objects based on their number of cars sold using the inhereited 
        * Comparable interface.
        * @param other the other Month object used for comparison 
        * @return integer representation of whether or not they are equal 
        */
        public int compareTo(Month other)
        {
            if(this.getCS()> other.getCS())
            {
                return -1;
            }

            if(this.getCS() < other.getCS())
            {
            return 1;
            }

            return 0; 
        }
    }
}


