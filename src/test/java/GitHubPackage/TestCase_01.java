package GitHubPackage;


//package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public abstract class TestCase_01 extends LinkedInWrappers {

	@Test
	public void linkIn() throws InterruptedException {

		String splitResult;
		String getName = "";
		String connection;

		// Launch Chrome
		invokeApp("Firefox", "https://www.linkedin.com/");

		// Login Linkedin
		loginLinkedInKarthi("karthielex@gmail.com", "sjb@1986");
		Thread.sleep(5000);

		// Click the Advaned Link
		clickByLinkText("Advanced");
		Thread.sleep(5000);

		//Enter the Search Search item
		enterById("main-search-box", "Selenium");

		//Click the Search button.
		//clickByClassName("search-button");
		Thread.sleep(5000);

		//Get the Reult 
		splitResult = getTextByXPath("//*[@id='results_count']/div/p/strong[1]");

		//Split the , from the count
		splitResult = Split(splitResult, ',');

		//Print the Result
		System.out.println("Result Count: " + splitResult);

		//Get the Name of the first connection
		getName = getTextByXPath("//*[@id='results']/li[1]/div/h3");
		connection = getTextByXPath("//*[@id='results']/li[1]/div/h3");
		getName = getName.substring(0, getName.length() - 3);

		//	Print the Name
		System.out.println("Name of the first person is :" + getName);

		//		Get the connection type
		connection = connection.substring(connection.length() - 3, connection.length());

		System.out.println("Connection is :" + connection);
	}

}

