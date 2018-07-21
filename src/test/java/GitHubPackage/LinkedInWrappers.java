package GitHubPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public abstract class LinkedInWrappers extends WrapperMethods {

	public boolean loginLinkedInKarthi(String userName, String passWord) {

		try {

			enterById("login-email", userName);
			enterById("login-password", passWord);
			clickByName("submit");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Unable to login");
			e.printStackTrace();
			return false;
		}
	}

	public String Split(String data, char spliter) {
		String afterSplit = "";
		for (char c : data.toCharArray()) {
			if (c != spliter) {
				afterSplit = afterSplit + c;
			}

		}
		return afterSplit;
	}

}
