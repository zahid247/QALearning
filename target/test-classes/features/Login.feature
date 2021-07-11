#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login into application
#
  #@tag1
  #Scenario: Positive test validating login
    #Given Initialize the browser with chrome
    #And Naviqate to "http://qaclickacademy.com/" site
    #And Click on sign in link to land on sign in page
    #When User enters "test99@gmail.com" and "123456" and logs in
    #Then Verify the user is successfully logged in

  @tag2
  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Naviqate to "http://qaclickacademy.com/" site
    And Click on sign in link to land on sign in page
    When User enters <username> and <password> and logs in
    Then Verify the user is successfully logged in
    And Close browsers

    Examples: 
      | username          | password |
      | test99@gmail.com  |   123456 |
      | test123@gmail.com | 41312567 |
