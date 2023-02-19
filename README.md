# Selenium-UI-Automation
Asians group project
it's UI automation of asians user system login and register pages.
Run this tests'
import the project into local machine or intellij
Navigate to Termial
Run mvn update
Run mvn clean -X test -DBrowser=chrome -DLocale=en -DEnvironment=UAT

Parameter Description:
Browser name :Chrome, edge, firefox and 
Environment :UAT
Localization : chinese(zh_cn) Japanese(ja),Enghist(en) and Korean(kr)

Test cases Automated:
LoginTest
ForgotPasswordTest
RegistrationTest
InvalidEmailAddressAndPasswordErrorMessage
BlankEmailAndPasswordErrorMessage
BlankForgotPasswordErrorMessage
BlankFieldsErrorMessageAtRegisterPage
LoginPageUI
RegistrationPageUI
BackToHomeLinkTest

