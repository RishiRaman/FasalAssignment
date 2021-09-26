================================================================================== BDD Cucumber Selenium Webdriver and Rest-Assured API Java Test Automation Framework
This project is a template test automation framework, which provides structured and standard way of creating automated test scripts for GUI, Mobile and API level tests across projects

This is a reusable automation framework that blends together Selenium WebDriver, REST ASSURED API Cucumber JVM (incorporating Gherkin and the BDD 'Given, When, Then, And ' testing construct)
This framework supports automation of : - 
*Web Browser : Chrome through SELENIUM
*REST API Automation [ POST, GET, PUT , DELETE] through REST ASSURED


The framework incorporates design principle of BDD (Behaviour driven development) which promotes writing acceptance tests by describing behaviour of application under test in simple english language from the perspective of its stakeholders. Having test written in Natural language helps the Project Team (Product Owners, Business Analysts, Development and QA team) to understand and track the requirements

Supports Custom Page Object model which represents the screens of AUT as a series of objects and encapsulates the fields represented by a page which ultimately avoids duplication and improves code maintainability and readability.

Sonar Continuous Code Quality Management: - conventions (Checkstyle), bad practices (PMD) and potential bugs (FindBugs).

Tools & libraries
The test automation framework is comprised of following tools and libraries

*Cucumber-JVM:- BDD Framework
*Custom Page Object Pattern and utility functions
*Selenium WebDriver: - Browser automation framework
*JAVA: - Programming language
*Maven: - Build tool
*Git OR SVN: - Version Control
*Github or Local Git Server: - Git repository hosted server
*Intellij Or Eclipse: - Integrated Development Environment
*AssertJ: - Matcher's
*Rest-Assured (optional): - Restful Api framework
*DriverManager

Test Automation framework support
Rishi Hisariya
Test Automation Lead
hisariya.rishi@gmail.com

Machine Configuration
Configure Ubuntu / Windows and setup: -
*Java 8
*Git / SVN
*Maven

Get the latest Source Code
Open Terminal or command line cd to the desired folder where the test automation source code needs to be checkout

Run command git clone https://github.com/RishiRaman/FasalAssignment.git

This will download the latest template source code

IDE Configuration
Intellij plugins
Configure and Install Following Plugins
File >> Setting >> Plugins >> Browser Repositories>

*Cucumber for Java *Gherkin *lombok *Git Integration/ SVN Integration
*Maven Integration *SonarQube (optional)

Eclipse plugins
Configure and Install Following Plugins
Help>>Install new software *Cucumber for Java http://cucumber.github.com/cucumber-eclipse/update-site

*Git Integration

Plugin configuration for Cucumber Feature Open Run Configurations Select Cucumber Feature and create one new configuration Project: automationFramework Feature: src/automationFramework/src/test/resources/features Glue: StepDefinitions Reports: monochrome, pretty HTML

File >> Setting >>
Search for Annotation Processing
(Java Compiler ... Annotation Processing>> Enable the check box

Import Project into Intellij
File>Import Project> Browse to automationFramework

Import Project into Eclipse
File>Import>Maven>Existing Maven Projects>Next> Browse to automationFramework Ensure pom.xml is found Finish

open terminal cd to test root directory run "mvn clean eclipse:eclipse"

Open "pom.xml" 
Compile Build or Run Tests
Command Line

RUN TEST : mvn clean test

Report
Local reports
Standard HTML Report
A report will be generated at /target/cucumber-reports/cucumber.html

Pretty Cucumber-Html Report
A report will be generated at /target/cucumber-reports/cucumber.html

Getting Started
Feature Files
These files contains the acceptance criteria which are written in Gherkin Language and contains various scenarios.

File Extension: *.feature
Location: "\src\test\resources\features"
Features: Separate features for GUI and API tests, Group common features files in a single directory
File Conventions:Meaning full name
Page Objects
PageObjects are used to store the WebElements for a Web Page. A good practice is to have a separate class for every single WebPage. To avoid duplication for multiple pages which have common web page elements a Parent class can be created and the child class can then inherit.
Every Page class extends "PageObject.class" to make use of the WebDriver Object and utility functions.
In case of Parent and Child Class, Parent class extends PageObject class and child class extends Parent class

Location: src/test/java/pageObjects Directory structure: Group common Page Objects classes in a single directory e.g Login Functionality Classes in Login Directory

Step Definitions
Every steps defined in Feature file needs to be implemented in Step Definitions Class

Location:\src\test\java\StepDefinitions 
Directory structure: Separate files for GUI and API tests, Group common step definition files in a single directory

RUN TEST : mvn clean test

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"StepDefinitions"},
        plugin = { "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json"},
        monochrome = true,
        tags = ""
)

public class RunnerTest {}
Where: -
features: represent the location of feature files from the compiled build
