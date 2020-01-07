*** Settings ***
Library  Selenium2Library
Documentation
...    Login Test Case.


***Variables***
${Browser}  Chrome
${URL}  http://localhost:8080/login


*** Test Cases ***
TestCase_1 Browser Start and Close
	Open Browser  ${URL}  ${Browser}
	Input Text  id=username  user123
	Input Password  id=password  abc123
	Click Button  xpath=//*[@id="login1"]/form/div[9]/button
	Close Browser