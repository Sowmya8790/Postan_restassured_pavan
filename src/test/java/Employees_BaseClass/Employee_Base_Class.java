package Employees_BaseClass;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Employee_Base_Class {
	
	public static RequestSpecification request;
	public static Response response;
	public Logger log;
	public static String EmpID = "24";
	public static String empname;
	public static String empsal;
	public static String empage;
	public static String Putempid = "2902";
	
	
	@BeforeClass
	public void logger() {
		
		log = log.getLogger("employee_Test_classes");
		PropertyConfigurator.configure("log4j.properties");
		log.setLevel(Level.DEBUG);
		
	}

}
