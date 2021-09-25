Feature: Verification of Automation Practice Business Scenario
  Background: Launch the browser and validate
    Given Launch the browser
    And the application is launched successfully

    Scenario: Verify the following Business Scenario Steps
      Given the user clicks on Women category link
      And the user clicks on the three filters
      Then the user clicks on Add to cart product with Twenty Seven Dollar value
      And the user changes color of the selected Twenty Seven Dollar value product
      And the user goes to Product page and changes the size to Medium from small size
      Then the user clicks on Add to cart button
      And the user proceeds to checkout the selected product
      Then the user clicks on Sign-In Link and enters username as "hisariya.rishi@gmail.com" and Password as "India@007"



