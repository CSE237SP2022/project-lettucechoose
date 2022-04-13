# Lettuce Choose - a kiosk app for customized salad!
   
By YJ Yoon, Kon Yoo, Tony Kwon, Jiwoo Seo


## 2nd Iteration
### What user stories were completed this iteration?
* Refactored structures of classes (Base, Protein, Topping) based on feedbacks and updated main() to reflect those changes.
* We have set limited quantity for Base, Protein, and Toppings. If there's no stock, users are prompted to make other choice.
* Drink menu is implemented - users can now add drinks to their orders. Each drink has different price.
* The receipt is prettier- used String formatter to format it nicely (so that it looks like a piece of paper)
  <img width="363" alt="Screen Shot 2022-04-13 at 3 42 22 AM" src="https://user-images.githubusercontent.com/43775491/163136845-d2f97cae-4f95-4cde-bb7f-2cdc5ab033e9.png">


### What user stories do you intend to complete next iteration?
* We worked so that users can quit the order at anytime - we are having progress, but did not merge into main because it's not complete yet. We will try to implement it by the next iteration.
* Vendors will be able to restock any sold-out items.
### Is there anything that you implemented but doesn't currently work?
* As mentioned above, we are trying to allow users to quit the order or the program.
### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
* At the root folder, run: <code> ./script.sh </code>
* If you are unable to run the bash script, try <code> chmod 744 script.sh </code>

* The user will be prompted to answer a set of questions to order a bowl of salad




## 1st Iteration
### What user stories were completed this iteration?
* Users can order customized salad in command lines. 
* Users can make multiple orders after orders. 
* Currently, base items have limited quantity. If there's no stock, users are prompted to make other choice.

### What user stories do you intend to complete next iteration?
* We need to implement other customizable items (such as drizzles, drinks) and allow more creativity to users.
* Prettier receipts with String Formatter
* The menu will adjust to the user's diet/allergies.
* We want to count every selling profit by each customer to show how much we sold for a given period of time.
* Protein and topping items will have limited quantity just like base items.
* We will improve our Order.java to keep track of the user's order. (rather than stack them in main.java)
   * While doing so, we'll make JUnit tests for complicated orders. 

### Is there anything that you implemented but doesn't currently work?
* We are trying to make our code as neat as possible - So some concerns arise in constructing classes and inner-classes.

### What commands are needed to compile and run your code from the command line (or better yet, provide a script that people can use to run your program!)
* At the root folder, run: <code> ./script.sh </code>
* If you are unable to run the bash script, try <code> chmod 744 script.sh </code>

* The user will be prompted to answer a set of questions to order a bowl of salad
* Below is an screenshot of a sample order
<img width="614" alt="image" src="https://user-images.githubusercontent.com/43775491/160733696-0236273a-29d8-4311-9340-cb2bcd286f40.png">
<img width="251" alt="image" src="https://user-images.githubusercontent.com/43775491/160733715-89eb8940-eb3b-42bc-8366-72db8e6d79b6.png">
