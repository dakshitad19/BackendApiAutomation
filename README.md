# BackendApiAutomation
TITLE
API automation using Rest Assured Library has been used 
Deliverables: 
•	Framework – Rest Assured
•	Config Reader File – Has all the common method to fetch the config.properties file.
•	Test cases are separated with different scenarios, there can be single class file but public methods of each test is different
•	Test case Report generation are in ALLURE HTML format will be open in browser.
LANGUAGE
 JAVA

BUILD AUTOMATION TOOL
Maven 

 POM File
Pom.xml consist of all dependencies 

IDE 
Intellj

PROJECT STRUCTURE DETAILS 
1.	Config.properties file has the Hostname(hosturl) and Endpoints
2.	Location of Config Reader =  RestAssured<  src < main <utils (inside this package , ConfigReader File is present 
3.	Location of Test files = RestAssured < src <main <test <java (has all the test classes)
4.	Circleci folder file is also present in the project 


REQUIREMENT #1
1.	Location - Rest Assured < src <main <test < java
2.	{# API =1} - UsersAPITest.java - contains the Assertion of status code , validate the username in the API , verify the ID in the API
3.	Reusable methods have been used 
4.	BaseUrl static method has been created once, using BaseUrl in entire program wherever it is needed
5.	 {# API =2} UserPostsTest has been created, assertion of status code and assertion of Title & Body along with the entire Response in String has been performed
6.	{# API =3} –In CommentsApi status code & comments in each post in the expected response

REPORT GENERATION (ALLURE)
1.	If using Inellj import the framework from Github run following commands
•	mvn clean package  - For BUILD SUCCESS
•	mvn compile package 
•	Go to < src <main <test < java -> Run All Tests, once all test has been executed in terminal of Intellij

2.	Run command =  allure serve allure-results 
3.	 As this allure-results folder is present in root directory.
4.	Allure Reports will be open in browser automatically after running this command , it will be in index.html format.





CREATED_BY
Dakshita Dhaundiyal
dakshitad19@gmail.com



![image](https://user-images.githubusercontent.com/32579088/169746072-dfe4412e-9c69-4546-925a-63f2b1872b4e.png)
