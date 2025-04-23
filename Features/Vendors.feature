Feature:Vendor

 Scenario Outline: Search Vendors
  Given User luanch chrome browser
  When User open url "<url>"
  When User enter email as "<email>" and password as "<password>"
  When User click on Login button
  #Then User validate title should be "<title>"
  When User click on customers menu
  And  User click on vendors item
  Then User see vendors page
  When User enter vendor name as "<vendorname>" and email as "<vendoremail>"
  And User click on search button
  And  User close broser
  
  Examples:
  |url                                      |email                        |password         |vendorname   |vendoremail                   |
  |https://admin-demo.nopcommerce.com/login |admin@yourstore.com          |admin            |Vendor 1     | vendor1email@gmail.com       |
  |https://admin-demo.nopcommerce.com/login |admininvalid@yourstore.com   |admin1234        |Vendor 2     | vendor2email@gmail.com       |

