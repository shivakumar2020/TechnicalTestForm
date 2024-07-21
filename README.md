
#Technical Test Form Automation Project


# Tools & technologies used for Mobile Automation

	>	Selenium Webdriver – for Web UI Automation 
	>	TestNG – Testing framework
	>	Java – Programming Language
	>	Maven – Build Tool
	>	Extent Report – Reporting
	>	Jenkins – CI / CD
	>	GitHub – Code repository


#Pre-requisites: 
The following software need to be installed in your machine.

	>	Jdk 11  (You can download from https://www.oracle.com/sg/java/technologies/javase/javase8-archive-downloads.html )
	>	Maven 3.9 (You can download from https://maven.apache.org/download.cgi )
	>	Eclipse IDE (https://www.eclipse.org/downloads/packages/release/photon/r )



#Running Selenium Automation Project in Local Machine:

	>	Download the zip or clone the Git repository => https://github.com/shivakumar2020/TechnicalTestForm.git 
	>	Unzip the zip file (if you downloaded)
	>	Open Command Prompt and Change directory (cd) to folder containing pom.xml. You can run from your terminal window > mvn clean test
	>	Run from Eclipse: Open Eclipse File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip and Select the project
	>	Right Click on the testing.xml file and Run as TestNG Suite or from command line run "mvn clean test"
	>	View the Test Result reports (AutomationReport.html ) from /reports folder in any browser
