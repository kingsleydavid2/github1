package GitHubPackage;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public interface GenericWrappers {

	public boolean invokeApp(String browser, String URL);
	public boolean verifyTitle(String title);
	public boolean enterById(String id, String data);
	public boolean clickById(String id);
	public String getTextById(String id) throws InterruptedException;
	public boolean verifyTextById(String id, String data);
	public boolean verifyTextContainsByID(String id, String text);
	public boolean isEnabledByID(String id);
	public boolean isVisibleByID(String id);
	public String verifyTextById1(String id, String data);
	public boolean switchToFrameByID(String id);
	public boolean verifyTitleContains(String title);

	public boolean clickByCSS(String CSS);
	public boolean enterByCSS(String CSS, String data);
	public String getTextByCSS(String CSS);
	
	public boolean clickByXPath(String XPath);
	public boolean enterByXPath(String XPath, String data);
	public String getTextByXPath(String XPath);
	public String verifyTextByXPath(String XPath, String data);
	public Select getDropDownByXPath(String XPath);
	public boolean verifyTextContainsByXPath(String XPath, String text);
	public boolean switchToFrameByXPath(String XPath);
	public List<WebElement> findAllElementsByXPath(String XPath);
	public int countAllElementsByXPath(String XPath);
	public boolean isEnabledByXPath(String XPath);
	public boolean isVisibleByXPath(String XPath);
	public boolean loginLinkedIn(String userName, String passWord);
	public String getTextByLinkText(String linktext);
	public boolean clickByLinkText(String linktext);
	public String getTextByClassName(String classname);
	public boolean getScreenShot();
	
}



