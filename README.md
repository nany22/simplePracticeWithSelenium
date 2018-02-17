# simplePracticeWithSelenium

Simple Automation project using InteliJ(as IDE), Java 8, Selenium, TestNG and Maven. It was done using the Pinterest Website, and using the Page Object Pattern.

Requirements:
*If you want to run the project using the testNG.xml, you can just run that and it will execute the hole suite (all tests will be performed)
*If you want to run the project using Maven, you just need a goal to execute that. I usually use "Install" as command line.
*So far, You need to set your user and password as variables in the HomeTest class.
*As known  issue, the wait of selenium is not so good, so even though you see the webelement, it is not found, so until I research a bit more and fix that, you can make it working just DEBUGING and not RUNING the tests.
eg: the ClickButton for login and the ClickLink for logOut, requires a wait.
*In inteliJ, just to be sure it is taking the right java, please set the java version (Eg:1.8) in the compiler.xml file inside of .idea folder. There is a code like this:

<bytecodeTargetLevel>
   <module name="SeleniumMaven_estructuraPOM" target="1.8" />
</bytecodeTargetLevel>






