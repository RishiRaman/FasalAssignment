Feature: Automation of ReqRes Scenarios

  Scenario: Verify Reqres.in POST / PUT / GET / DELETE calls

    Given the POST call is done to REGISTER-SUCCESSFUL Api and response is validated Successfully
    And the POST call is done to CREATE Api and response is validated Successfully
    When the GET call is done to fetch the SINGE USER and response is validated Successfully
    And the GET call is done to fetch LIST of USERS and response is validated Successfully
    Then the PUT call is done to modify user and response is validated Successfully
    Then  the DELETE call is done and response is validated Successfully