/* Programmer: Alliyah Mohammed */

//Import classes 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException; 
import java.util.Scanner; 
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.io.File;


/**
 * class CarDealershipSimulator contains a main method that is used to execute the dealership and make
 * use of the other various java files. 
 */

public class CarDealershipSimulator 
{
	//Constant integer for the number of wheels of each car 
	private static final int _4 = 4;

public static void main(String[] args)
  {
		//a new CarDealership object
		CarDealership dealer = new CarDealership();

		//A string used to hold the display of the last purchase
		String bought = "";
	  	  
		// an (initially empty) array list of type Car
		ArrayList<Car> newCars = new ArrayList<Car>(); 

		//Create an accounting system object
		AccountingSystem dAS = dealer.getAS();

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

		//Try block to check for any potential errors
		try
		{
			File inputFile = new File("cars.txt");

			Scanner in = new Scanner(inputFile);

			//While there is another car in the file
			while(in.hasNextLine())
			{
				Scanner newC = new Scanner(in.nextLine());

				String mfw = newC.next();
				String colour = newC.next();
				String model = newC.next();
				String eng = newC.next();
				double sr = Double.parseDouble(newC.next());
				int range = Integer.parseInt(newC.next());
				String awd = newC.next();
				boolean awdVal;

				//Check if the current car is AWD or not
				if(awd.equals("2WD"))
				{
					awdVal = false;
				}

				else
				{
					awdVal = true;
				}

				double price = Double.parseDouble(newC.next());

				//Check is the car is electric and add appropriate car object to the list
				if(newC.hasNext())
				{
					int chargeTime = newC.nextInt();
					newCars.add(new ElectricCar(mfw, colour, model, eng, sr, range, awdVal, price, _4, chargeTime , "LITHIUM"));
					continue;

				}

				//Add the car to the array list
				newCars.add(new Car(mfw, colour, model, eng, sr, range, awdVal, price, _4));

			}

			in.close();

		}

		//Catch error thrown due to missing file
		catch(FileNotFoundException e)
		{
			System.out.println("The input file could not be found! - " + e);
		}
			
		//Scanner object to get user input
		Scanner input = new Scanner(System.in);
	  
	 //Try block to check statements that may cause an exception 
	 try
	 {
		 //While loop to check user input
		while(input.hasNextLine())
		{
			//Scanner object to read next line from user input
			Scanner commandLine = new Scanner(input.nextLine());
			

			//Switch structure to check user input
			switch (commandLine.next())
			{
			
			//Add cars to dealership
			case "ADD": dealer.addCars(newCars);
						System.out.println("\n");
						break;
			
			//List dealership inventory
			case "L":	System.out.println("\n");
						dealer.displayInventory();
						System.out.println("\n");
						break;

				//Quit program
				case "Q": commandLine.close();
						  return;

				//Buy a car 
				case "BUY": try
							{
								if(commandLine.hasNextInt())
								{
									int vin = commandLine.nextInt();
									bought = dealer.buyCar(vin);
									System.out.println(bought + "\n");
								}
								break;
							}

							catch(IndexOutOfBoundsException e)
							{
								System.out.println(e);
							}

				//Return purchased car to dealership
				case "RET": try
							{
								if(commandLine.hasNextInt())
								{
									int id = commandLine.nextInt();
									dealer.returnCar(id);
									System.out.println("Car being RETURNED: " + bought + "\n");
									bought = "";
									break;
								
		
								}
							}

							//Catch error due to an object/variable being null 
							catch(NullPointerException e)
							{
								System.out.println("You did not enter a valid transaction ID! - " + e + "\n");
							}

							//Catch error due to calling a command that has an empty list 
							catch(IllegalStateException e)
							{
								System.out.println("There are currently no transactions on record! Please purchase a car before trying to return. - " + e + "\n");
							}
							break;

				case "SALES": 
						//If there is another word in the input 
						if(commandLine.hasNext())
						{	 
				
							if(commandLine.hasNextInt())
							{
								int m = commandLine.nextInt();
								if(m >= 0 && m <= 11)
							  {
								  int month = m;

								  ArrayList<String> montlySales = dAS.salesByMonth(month);
								  System.out.println("The transactions for the month " + monthMap.get(month) + " are:");
								  for(int i = 0; i < montlySales.size(); i++)
								  {
									  System.out.println(montlySales.get(i) + "\n");
								  }
								  break;
							  }
							}

							String c = commandLine.next();

							   //SALES TOPSP command
							   if(c.equals("TOPSP"))
							   {
									 System.out.println("Top Sales Person: " + dAS.topSalesPerson() + "\n");
									 break;
							   }

							  //SALES TEAM command
							   if(c.equals("TEAM"))
							  {
								   SalesTeam team = new SalesTeam();
								   System.out.println(team.displayTeam() + "\n");
								   break;
							  }
							 

							  //SALES STATS command
							    if(c.equals("STATS"))
							  {
									double totalSales = dAS.getTSY();
									double avgSalesPerMonth = totalSales / 12;
									int totalSold = dealer.getTotalBuys();

									String highestSalesMonth = dAS.topSalesMonth();
									int totalRET = dealer.getTotalRet();
									  
									System.out.println("Total Sales: $" + totalSales + "\n");
									System.out.printf("Average Sales per Month: $%.1f", avgSalesPerMonth);
									System.out.println("\n");
									System.out.println("Highest Sales Month: " + highestSalesMonth + "\n");
									System.out.println("Total Cars Sold: " + totalSold + "\n");
									System.out.println("Total Cars Returned: " + totalRET + "\n");
									break;
							  }
							}

							//Print all the transactions - SALES command
							else
							{
								ArrayList<Transaction> allTrans = dAS.getAllTrans();
								for(int i = 0; i < allTrans.size(); i++)
								{
									System.out.println(allTrans.get(i).display() + "\n");
								}
							}

							break;

				//Sort dealership by price
				case "SPR": dealer.sortByPrice();
							System.out.println("\n");
							break;
				
				//Sort dealership by safety rating
				case "SSR": dealer.sortBySafetyRating();
							System.out.println("\n");
							break;

				//Sort dealership by max range
				case "SMR": dealer.sortByMaxRange();
							System.out.println("\n");
							break;

				//Filter inventory by given price range
				case "FPR": if(!commandLine.hasNextDouble())
							{
								continue;
							}
								
							double min = commandLine.nextDouble();

							if(!commandLine.hasNextDouble())
							{
								continue;
							}

							double max = commandLine.nextDouble();

							if(min > max)
							{
								System.out.println("This is not a valid range!" + "\n");
								break;
							}

							dealer.filterByPrice(min, max);
							System.out.println("\n");
							break;

				//Filter inventory by electric cars	
				case "FEL": dealer.filterByElectric();
							System.out.println("\n");
							break;

				//Filter inventory by AWD
				case "FAW": dealer.filterByAWD();
							System.out.println("\n");
							break;
							
				//Clear all filters
				case "FCL": dealer.filtersClear();
							System.out.println("\n");
							break;

				//Default case for invalid input 
				default: System.out.println("You did not enter a valid command. Please try again!" + "\n");
						 break; 


			}
		}

		input.close();
		
	}

	//Catch error due to invalid input
	catch(NoSuchElementException NSE)
		{
			System.out.println("invalid command!" + "\n");
			System.out.println(NSE + " has occured" + "\n");
		}
  }
}
