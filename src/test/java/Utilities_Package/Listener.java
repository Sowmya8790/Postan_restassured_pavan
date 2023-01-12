package Utilities_Package;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//public class Listener extends TestListenerAdapter{

public class Listener implements ITestListener{
	
	public ExtentReports extent;
	public ExtentTest test;
	
	//public ExtentHtmlReporter htmlreporter;
	
	public void onStart(ITestContext context) {

		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReport" + Random_values.getdate());
		//extent.attachReporter(htmlreporter);
		extent.addSystemInfo("name", "Sowmya");
		extent.addSystemInfo("Environment", "Dev");
		extent.addSystemInfo("resource", "QA Team");
		
	}
		
	public void onTestStart(ITestResult result) {
		
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, "The test is started" + result.getName());
		
	}
	public void onTestSuccess(ITestResult result) {

		test = extent.startTest(result.getName());
		test.log(LogStatus.PASS, "The test is passed" + result.getName());
		
	}
	public void onTestFailure(ITestResult result) {

		test = extent.startTest(result.getName());
		test.log(LogStatus.FAIL, "The test is failed" +result.getName());
		test.log(LogStatus.FAIL, result.getThrowable());
		
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.SKIP, "This test is skipped" + result.getName());
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
		
	}
	
/*	public void onstart(ITestContext testontext) {
		
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/ExtentReport/Myreport.html");
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setReportName("RestAssured Test reports");
		htmlreporter.config().setTimeStampFormat("ddmmyyyy");
		htmlreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports(System.getProperty("user.dir") +"/ExtentReport/Myreport.html");
		//extent.attachReporter(htmlreporter);
		extent.addSystemInfo("name", "Sowmya");
		extent.addSystemInfo("Environment", "Dev");
		extent.addSystemInfo("resource", "QA Team");
		
	} */
	
	
}
