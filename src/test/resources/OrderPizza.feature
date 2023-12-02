Feature: Order Pizza from Swiggy 
Scenario: Order Pizza From Swiggy

Given Navigate to the landing page of Swiggy 
When Enter location as Mumbai
Then Redirect to the ItemPage
And Hover over search icon
Then Enter Item as Pizza and search
When Search resturant and select Pizza Hut
And Redirect to orderPage and order Margherita
Then Add one Margherita to cart 
When Click on Cart button
Then Verify Checkout page is loaded correctly

#Examples: 
#|city|
#|Mumbai|
#|Chennai|
