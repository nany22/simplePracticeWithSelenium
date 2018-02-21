# simplePracticeWithSelenium

Simple Automation project using InteliJ(as IDE), Java 8, Selenium, TestNG and Maven. It was done using the Pinterest Website, and using the Page Object Pattern.

Requirements: 
* If you want to run the project using the testNG.xml, you can just run that and it will execute the hole suite (all tests will be performed)
* If you want to run the project using Maven, you just need a goal to execute that. I usually use "Install" as command line.
* So far, You need to set your user and password as variables in the HomeTest class.(Im working on that )
* TestNG is not JUnit. Don't missmatch @BeforeTest/AfterTest and @BeforeMethod/AfterMethod.
    I used @AfterMethod/@BeforeMethod instead @AfterTest/@BeforeTest because "Test" doesn't mean before each test.See http://testng.org/doc/documentation-main.html#annotations
* Documentation for public stuff are placed on src/test/javadoc directory
* In inteliJ, just to be sure it is taking the right java, please set the java version (Eg:1.8) in the compiler.xml file inside of .idea folder. There is a code like this:

<bytecodeTargetLevel>
   <module name="SeleniumMaven_estructuraPOM" target="1.8" />
</bytecodeTargetLevel>






