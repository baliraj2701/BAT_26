Feature:Customer

@regression
Scenario Outline: Add New Customer
  Given User luanch chrome browser
  When User open url "<url>"
  When User enter email as "<email>" and password as "<password>"
  When User click on Login button
  #Then User validate title should be "<title>"
   When user click on customers menu
   And  User click on customers menu item
   And User click on new add button
   Then User can view add new customer page
   When user enter customer info as "<newEmail>" and "<newPass>" and "<fname>" and "<lname>" and "<gender>" and "<comName>" and "<adminCommenet>"
   And user click on save button
   Then User can view confirmation msg "The new customer has been added successfully."
   And close browser
   
    Examples:
  |url |email|password|newEmail|newPass|fname|lname|gender|comName|adminCommenet|
  |https://admin-demo.nopcommerce.com/login |admin@yourstore.com|admin|raj122@gmail.com|1234|Bali77|Raj|Male|ABC|Test11|
  |https://admin-demo.nopcommerce.com/login |admin14252@yourstore.com|admin|radhika133@gmail.com|4537|Radhika|Patel|Female|xyz|Test2|

   
   
 
