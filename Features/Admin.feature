Feature: Admin Feature file

  @smoke
  Scenario: Login with valid credential
  Given User luanch chrome browser
  When User open url "https://admin-demo.nopcommerce.com/login"
  When User enter email as "admin@yourstore.com" and password as "admin"
  When User click on Login button
  #Then User validate title should be "Dashboard / nopCommerce administration"
  And  User close broser
  
  @sanity
  Scenario Outline: Login with data driven testing
  Given User luanch chrome browser
  When User open url "<url>"
  When User enter email as "<email>" and password as "<password>"
  When User click on Login button
  #Then User validate title should be "<title>"
  And  User close broser
  
  Examples:
  |url                                      |email                        |password                   |
  |https://admin-demo.nopcommerce.com/login |admin@yourstore.com          |admin                      | 
  |https://admin-demo.nopcommerce.com/login |admininvalid@yourstore.com   |admin1234                  |  
 
  


  
      
 
