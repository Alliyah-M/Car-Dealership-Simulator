/* Programmer: Alliyah Mohammed */

//Import classes
import java.util.LinkedList; 
import java.util.ListIterator;
import java.util.Random;

/**
 * Class SalesTeam creates a linked list of Strings containing the sales team member names, 
 * and contains a get and display method.
 */

public class SalesTeam
{
    //Instance variables
    private LinkedList<String> salesTeam;
    
    /**
     * Constructor method to add sales persons to the sales team
     */
    public SalesTeam()
    {
        salesTeam = new LinkedList<String>();
        salesTeam.add("Charles Manson");
        salesTeam.add("Ted Bundy");
        salesTeam.add("Jeffrey Dahmer");
        salesTeam.add("John Gacy");
        salesTeam.add("John Kramer");
        salesTeam.add("Henry Holmes");

    }

    /**
     * Method to get the name of a sales person
     * @return the name of the sales person
     */
    public String getSalesPerson()
    {
        Random rand = new Random();

        int i = rand.nextInt(6);

        return salesTeam.get(i);
    }

    /**
     * Method to display the sales team
     * @return string representation of the sales team
     */
    public String displayTeam()
    {
        ListIterator<String> iterator = salesTeam.listIterator();

        String team = "";

        while(iterator.hasNext())
        {
            if(iterator.hasNext())
            {
                team += iterator.next() + ", ";
            }

            else
            {
                team += iterator.next();
            }
        }

        return "Sales Team: " + team;
        
    }

    /**
     * Method to return the number of peaople on the sales team
     * @return size of the sales team
     */
    public int teamSize()
    {
        int size = 0;

        ListIterator<String> iterator = salesTeam.listIterator();

        while(iterator.hasNext())
        {
            size++;
        }

        return size;
    }

    /**
     * Method to get a specified sales person in the linked list
     * @param n the index of the sales person to get
     * @return the name of the sales person
     */
    public String getNthSalesPerson(int n)
    {
        int count = 1;
        String p = "";


        for(String person: salesTeam)
        {
            if(count == n)
            {
                p = person;
            }

            count++;

        }

        return p;
    }
}
