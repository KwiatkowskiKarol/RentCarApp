*** Settings ***
Library  Selenium2Library
Documentation
...    Car Search Test Case.

*** Test Cases ***
The user can search for car
    Select Car For Rent   Ford
    Search For Car
    There are available Cars