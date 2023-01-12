package Utilities_Package;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Random_values {
	
	public static String getempname() {
		
		String getrandomstring = RandomStringUtils.randomAlphabetic(2);
		String empname =("Jhon" + getrandomstring);
		return empname;
		
	}
	
	public static String getempsalary() {
		
		String getempsal = RandomStringUtils.randomAlphabetic(5);
		
		return getempsal;
	}
	
	public static String getempage() {
		String empage = RandomStringUtils.randomAlphabetic(2);
		return empage;
	}
	public static String getdate() {
		
		String date = RandomStringUtils.randomNumeric(2);
		return date;
	}

                    
}
