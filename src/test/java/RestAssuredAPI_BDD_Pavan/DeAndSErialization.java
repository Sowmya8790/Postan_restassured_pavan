package RestAssuredAPI_BDD_Pavan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	
	int i =10, j=20;
	
	
}

public class DeAndSErialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//creating object for above class
		
		Test t1= new Test();
		
		//serialization
		FileOutputStream fs = new FileOutputStream("Test.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fs);
		
		oos.writeObject(t1);
		
		//deserialization
		
		FileInputStream fis = new FileInputStream("Test.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Test t2 = (Test) ois.readObject();
		System.out.println(t2.i +" " +t2.j);
		
		
		
		
		

	}

}
