*** Settings ***
Library  SeleniumLibrary

*** Variables ***
${BROWSER}   chrome
${SELSPEED}  0.0s

*** Test Cases ***
SuccessfulRegistration
    [Setup]  Run Keywords  Open Browser  http://automationpractice.com/index.php?id_category=8&controller=category  ${BROWSER}
    ...              AND   Set Selenium Speed  ${SELSPEED}
    # open    http://automationpractice.com/index.php?id_category=8&controller=category
    click    link=Sign in
    click    id=email_create
    doubleClick    id=email_create
    type    id=email_create    siema@wp.pl
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Email address'])[1]/following::span[1]
    click    id=id_gender1
    type    id=customer_firstname    Janusz
    type    id=customer_lastname    Kowslaki
    type    id=passwd    januszkowalski
    click    id=days
    select    id=days    regexp:3\s+
    click    id=days
    click    id=months
    select    id=months    regexp:March\s
    click    id=months
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::div[6]
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='Date of Birth'])[1]/following::div[6]
    click    id=years
    select    id=years    regexp:2013\s+
    click    id=years
    click    id=company
    type    id=company    wykapany
    type    id=address1    siemano 5/10
    type    id=city    Nibylandia
    click    id=id_state
    select    id=id_state    Iowa
    click    id=id_state
    click    id=postcode
    type    id=postcode    00000
    click    id=phone_mobile
    type    id=phone_mobile    123456789
    click    id=alias
    click    xpath=(.//*[normalize-space(text()) and normalize-space(.)='DNI / NIF / NIE'])[1]/following::span[1]
    [Teardown]  Close Browser

*** Keywords ***
open
    [Arguments]    ${element}
    Go To          ${element}

clickAndWait
    [Arguments]    ${element}
    Click Element  ${element}

click
    [Arguments]    ${element}
    Click Element  ${element}

sendKeys
    [Arguments]    ${element}    ${value}
    Press Keys     ${element}    ${value}

submit
    [Arguments]    ${element}
    Submit Form    ${element}

type
    [Arguments]    ${element}    ${value}
    Input Text     ${element}    ${value}

selectAndWait
    [Arguments]        ${element}  ${value}
    Select From List   ${element}  ${value}

select
    [Arguments]        ${element}  ${value}
    Select From List   ${element}  ${value}

verifyValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

verifyElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

verifyTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

verifyTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertConfirmation
    [Arguments]                  ${value}
    Alert Should Be Present      ${value}

assertText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

assertElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

assertTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

assertTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForText
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForValue
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

waitForElementPresent
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForVisible
    [Arguments]                  ${element}
    Page Should Contain Element  ${element}

waitForTitle
    [Arguments]                  ${title}
    Title Should Be              ${title}

waitForTable
    [Arguments]                  ${element}  ${value}
    Element Should Contain       ${element}  ${value}

doubleClick
    [Arguments]           ${element}
    Double Click Element  ${element}

doubleClickAndWait
    [Arguments]           ${element}
    Double Click Element  ${element}

goBack
    Go Back

goBackAndWait
    Go Back

runScript
    [Arguments]         ${code}
    Execute Javascript  ${code}

runScriptAndWait
    [Arguments]         ${code}
    Execute Javascript  ${code}

setSpeed
    [Arguments]           ${value}
    Set Selenium Timeout  ${value}

setSpeedAndWait
    [Arguments]           ${value}
    Set Selenium Timeout  ${value}

verifyAlert
    [Arguments]              ${value}
    Alert Should Be Present  ${value}
