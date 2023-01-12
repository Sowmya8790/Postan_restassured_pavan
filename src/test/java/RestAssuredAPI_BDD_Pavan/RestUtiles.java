package RestAssuredAPI_BDD_Pavan;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtiles {

	public static String getrandname() {
		
		String empname = RandomStringUtils.randomAlphabetic(3);
		return ("Swmya" + empname);
	}
			
		public static String getrandsalary() {
				
				String empsal = RandomStringUtils.randomNumeric(5);
				return ("7" + empsal);
			}
		
		public static String getrandage() {
			
			String empage = RandomStringUtils.randomNumeric(2);
			return (empage);
		}

}
