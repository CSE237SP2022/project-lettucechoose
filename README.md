# Lettuce Choose - a kiosk app for customized salad!
   
By YJ Yoon, Kon Yoo, Jiwoo Seo

## Users can..
1. Order a customized salad.
   - Choose a base, a protein, three toppings.
2. Add some tips to their orders.
3. Quit the order at any time.
4. Get a virtual receipt.
5. Make orders after orders.
6. If the user is a vendor, s/he can restock sold-out ingredients. 
   - Initial quantities of ingredients are set to 3.
* If an ingredient is ordered three times, it gets sold-out, and cannot be ordered unless a vendor restocks it. Try this feature as well!

## To run the program..
* At the root folder, run: <code> ./script.sh </code>
* If you are unable to run the bash script, try <code> chmod 744 script.sh </code>
* The user will be prompted to answer a set of questions to order a bowl of salad
* To quit the program, press <code> ctrl+c </code>
* To quit the order, press <code> q </code>
      

## 3rd Iteration
### What user stories were completed this iteration?
* Users can now quit their orders at any time. (They can type 'q')
* Vendors can check the quantities of ingredients and restock them.
   * At the start of the order, vendors can type 'vendor' to log-in to vendor page. 
   * We first implemented this feature without informing the non-vendor users (customers), but for the reviewers, we decided to make it more public.

### Is there anything that you implemented but doesn't currently work?
* All the functionalites should run.



<details>
<summary><b>Previous Iterations</b></summary>

### 2nd Iteration
#### What user stories were completed this iteration?
* Refactored structures of classes (Base, Protein, Topping) based on feedbacks and updated main() to reflect those changes.
* We have set limited quantity for Base, Protein, and Toppings. If there's no stock, users are prompted to make other choice.
* Drink menu is implemented - users can now add drinks to their orders. Each drink has different price.
* The receipt is prettier- used String formatter to format it nicely (so that it looks like a piece of paper)
  <img width="363" alt="Screen Shot 2022-04-13 at 3 42 22 AM" src="https://user-images.githubusercontent.com/43775491/163136845-d2f97cae-4f95-4cde-bb7f-2cdc5ab033e9.png">


#### What user stories do you intend to complete next iteration?
* We worked so that users can quit the order at anytime - we are having progress, but did not merge into main because it's not complete yet. We will try to implement it by the next iteration.
* Vendors will be able to restock any sold-out items.
#### Is there anything that you implemented but doesn't currently work?
* As mentioned above, we are trying to allow users to quit the order or the program.

### 1st Iteration
#### What user stories were completed this iteration?
* Users can order customized salad in command lines. 
* Users can make multiple orders after orders. 
* Currently, base items have limited quantity. If there's no stock, users are prompted to make other choice.

#### What user stories do you intend to complete next iteration?
* We need to implement other customizable items (such as drizzles, drinks) and allow more creativity to users.
* Prettier receipts with String Formatter
* The menu will adjust to the user's diet/allergies.
* We want to count every selling profit by each customer to show how much we sold for a given period of time.
* Protein and topping items will have limited quantity just like base items.
* We will improve our Order.java to keep track of the user's order. (rather than stack them in main.java)
   * While doing so, we'll make JUnit tests for complicated orders. 

#### Is there anything that you implemented but doesn't currently work?
* We are trying to make our code as neat as possible - So some concerns arise in constructing classes and inner-classes.



</details>
