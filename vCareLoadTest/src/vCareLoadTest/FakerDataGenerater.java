package vCareLoadTest;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerater 
{
@Test
	void testGenerateDummyData()
	{
		Faker faker=new Faker();
	String Firstname =	faker.name().firstName();
	String Lastname =	faker.name().lastName();
		
	 String username = faker.name().username();
	String password = faker.internet().password();
	
	String phoneno = faker.phoneNumber().cellPhone();
	String Email = faker.internet().safeEmailAddress();
	
	System.out.println("Firstname" +Firstname);
	System.out.println("Lastname" +Lastname);
	System.out.println("username" +username );
	System.out.println("password" +password);
	System.out.println("Email" +Email);
	
	
	}
	
}
