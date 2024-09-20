# Vikunja Registration Automation Test

This project contains an automated test to verify the negative flow of the registration process on the [Vikunja](https://try.vikunja.io/register) website using Selenium and Java. 
The test checks if the application properly handles the case when a user attempts to register with a username that is less than 3 characters.

## Prerequisites

Before running the test, ensure you have the following installed on your system:

- **Java Development Kit (JDK)** (version 8 or above)
- **Maven** (for managing dependencies and running the test)
- **Chrome Browser** (for running the test using ChromeDriver)
  
 Install Dependencies Maven will automatically download the necessary dependencies listed in the pom.xml file. Simply run the following command to ensure all dependencies are installed:
  mvn clean install
  
Running the Test

1.Run the Test Using Maven To execute the test, use the following command:
mvn test

2.Expected Output
The browser will open and navigate to the registration page.
The test will attempt to register with a 2-character username.
It will validate that the error message "Username must have at least 3 characters" is displayed and that the username field is highlighted in red.
Results will be displayed in the terminal.

3.Test Script Details
Class Name: VikunjaRegistrationTest
Assertions:
Checks for the presence of the error message.
Validates that the username field is highlighted in red.

4.Dependencies
Selenium Java: For browser automation.
WebDriver Manager: For automatically handling browser drivers.
TestNG: For structuring and running the tests.
These dependencies are managed via Maven and are specified in the pom.xml file.

5.Troubleshooting
If the test fails to run, ensure that:
Java and Maven are installed and configured properly.
All dependencies are correctly installed.
The browser version matches the WebDriver being used.
