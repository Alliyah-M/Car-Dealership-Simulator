# Car-Dealership-Simulator
/*
CPS 209 Assignment 2
Programmer: Alliyah Mohammed                              
Date: Friday April 12th, 2019                             
                                                             
This program is a car dealership simulator, that               
takes in an array list of various car objects and              
allows the user to sort, buy or return the cars. As well as    
see various info regarding all of the sales. File              
I/O is used to read in cars from a text file.*/

Note: Program works as intended, however due to the nature of the random generator there is the possibility
      of duplicate VIN and ID numbers. The commands for the program are as follows: 

		"ADD": Adds new cars to the dealership.

		"L": List the cars within the dealership.
		
		"Q": Quit the program.

		"BUY v": v is the VIN of the car the user would like to purchase. This command lets a user buy car, removing it from the dealership inventory. 

		"RET i": i is the transaction ID associated with the car they would like to return. This command returns the specified car that was bought to the dealership inventory.
			
		"SALES": prints all the transactions that have taken place for the year (2019).

		"SALES TEAM": Prints the names of all the sales people. 

		"SALES TOPSP": prints the name of the top sales person as well as how many sales they have had. 

		"SALES m": m is an integer representation of the month (Jan - 0, Dec - 11). All the transactions for this month are printed. 

		"SALES STATS": Prints the total sales for the year based on price, the average sales per month based on price, the total number of cars sold,
			       the highest sales month in terms of number of cars sold, and the total car returns.  

		"SPR": Sort dealership inventory by price.

		"SSR": Sort dealership inventory by safety rating.

		"SMR": Sort dealership inventory by max range.

		"FPR": must be followed by two valid prices, filters inventory to show all cars within the entered range.

		"FEL": Filters the dealership inventory to only show electric cars . 

		"FAW": Filters the dealership inventory to only show cars that are all wheel drive.

		"FCL": Clears all filters. 

		

		



