﻿# Online-Restaurant-Ordering-System
 Convert your solution in assignment 1 to be an MVC Java web application. In assignment 2, you need to use a RDBMS such as Oracle and MySql, or any other database system. You need to store the user accounts in the database. Also, you need to store all the orders in the database. Each user can query his/her past orders. You need to add the price of each meal and the total price for each order.
You need to apply the MVC architectural pattern properly. 
You need to use sessions properly.
Requirements 
The restaurant has the following meals:
Burgers
Pizza
Pasta
The customer may order as many meals.
The customer may order regular or customized meals.
Types of burgers:
Regular Beef Burger
Regular Chicken Burger
You can customize your burger by adding cheese, lettuce, tomatoes. Also, you can select the weight of meat in the burger (100g, 150g, 200g, 250g).
Types of Pizza:
Italian, Jordanian, etc. (you can add whatever you want)
You can customize the pizza by adding your favorite toppings (olives, onions, corn, ...)
Size of pizza in inches (small, medium, big)
Types of Pasta:
Spagitti, Panneni, etc.
You can choose whether beef or chicken.
        (You can add whatever customization options)
You need to provide a good object oriented design for the problem.
In this assignment, your program should do the following:
Take the customer order
Keep track of all the user orders in his session
The system should keep track of all the orders (orders from all users)
For now, you don’t need to use a DB to store the orders. Just keep them in memory
The main form should contain the following:
User name
Add Meal button, when the user clicks this button, he should receive a response from the server with the following options:
Select Meal Type (burger, pizza, pasta)
Customize meal options (based on the requirements above).
The user can add another meal using the Add Meal button.
Then the user will submit his/her order to the application. 
The application will store the order in the list of orders for all users, also the user shall be able to view his orders.
