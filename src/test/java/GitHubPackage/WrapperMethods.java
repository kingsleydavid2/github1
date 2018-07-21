package GitHubPackage;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.support.ui.Select;



public abstract class WrapperMethods implements GenericWrappers {
	private static final long SSFolder = 0;
	RemoteWebDriver driver;
	private String getText1;
	private Object text;
	
public boolean invokeApp(String browser, String URL) {
		
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else {
				System.out.println("Please pass correct browser type "
						+ browser);
				//	getScreenShot();
				return false;
			}
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//	getScreenShot();
		} catch (WebDriverException e) {
			// TODO: handle exception
			{
				System.out.println("browser not opened"+e);
			//	getScreenShot();
				return false;
			}
			// TODO Auto-generated method stub
			
		}
		return false;
		
}


	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub

		{
			
			if(driver.getTitle().contains(title))
			{
				System.out.println(" Title contains "+title );
				return true;
			}
			else
			{
				System.out.println("title doesn't contains"+title);
				return false;
			}
		}
		
							
			}


//	public boolean enterById(String id, String data) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public boolean clickById(String id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public String getTextById(String id) throws InterruptedException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public boolean verifyTextById(String id, String data) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public boolean verifyTextContainsByID(String id, String text) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public boolean isEnabledByID(String id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public boolean isVisibleByID(String id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public String verifyTextById1(String id, String data) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public boolean switchToFrameByID(String id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//
//	public boolean verifyTitleContains(String title) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
	
			
		public boolean clickById(String id) {
			try {
				driver.findElementById(id).click();
				System.out.println("Clicked Button is confirmed");
				return true;
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("No Such Element Found"+id);
				e.printStackTrace();
				return false;
			}
			catch (ElementNotVisibleException e) 
			{
				System.out.println("Element is not visisble" + e);		
				//getScreenShot();
				return false;
			}


			}


		
		
		public boolean enterById(String idValue, String data) {

			try 
			{
				driver.findElement(By.id(idValue)).sendKeys(data);
				System.out.println("Enter Text is" + data);

			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
			return true;
		}

			
//		public String getTextById(String id) {
//			// TODO Auto-generated method stub
//			return null;
		//		}
		
		public String getTextById(String id) throws InterruptedException{
			
			try 
			{
				Thread.sleep(30000);
			String getText1 = driver.findElement(By.id(id)).getText();
				System.out.println("getText is" + getText1);
			}
			catch (NoSuchElementException e) 
			{
				System.err.println("Element is not found" + e);	
			//	getScreenShot();
				
			}
			
			catch (InvalidSelectorException e)
			{
				System.err.println("CSS Selector used is invalid. Please use correct locator" + e);
				// getScreenShot();
				
			}
			catch (ElementNotVisibleException e) 
			{
				System.err.println("Element is not visisble" + e);		
				// getScreenShot();
				
			}
			
	   return getText1;
		
		}
		

		//public String verifyTextById(String id, String data) {
//			// TODO Auto-generated method stub
//			return null;
		
			
		public boolean verifyTextContainsByID(String id, String text) {
			
				try 
				{
					String id1 = driver.findElement(By.id(id)).getText();
					if(id1.contains(text))
					{
						System.out.println("Enter Text Contains is" + text);
						return true;

					}
					else			
						return false;
				} 
				catch (NoSuchElementException e) 
				{
					System.err.println("Text Element is not found" + e);		
					//getScreenShot();
					return false;
				}
				catch (InvalidSelectorException e)
				{
					System.err.println("Incorrect Text contains" + e);
					//getScreenShot();
					return false;
				}
				catch (ElementNotVisibleException e) 
				{
					System.err.println("Element is not visisble" + e);		
					//getScreenShot();
					return false;
				}
			}


		


		public boolean isEnabledByID(String id) {
			// TODO Auto-generated method stub
			try 
			{
				if(driver.findElement(By.id(id)).isEnabled())
						{
					System.out.println("SearchIcon is enabled");
					return true;
						}
				else
					return false;
			}
			
			catch (NoSuchElementException e) 
			{
				System.err.println("Element is not found" + e);		
				//getScreenShot();
				return false;
			}
			catch (InvalidSelectorException e)
			{
				System.err.println("Search icon used is invalid. Please use correct locator" + e);
				//getScreenShot();
				return false;
			}
			catch (ElementNotVisibleException e) 
			{
				System.err.println("Search Icon is not visisble" + e);		
			//	getScreenShot();
				return false;
			}
			
		}


		public boolean isVisibleByID(String id) {
			// TODO Auto-generated method stub
			try 
			{
				if(driver.findElement(By.id(id)).isDisplayed())
				{
					System.out.println("SearchIcon is visible");
				return true;
				}

				else			
					return false;
			} 
			catch (NoSuchElementException e) 
			{
				System.err.println("Element is not found" + e);		
				return false;
			}
			catch (ElementNotVisibleException e) 
			{
				System.err.println("Element is not visisble" + e);		
				//getScreenShot();
				return false;
			}
			catch (InvalidSelectorException e)
			{
				System.err.println("CSS Selector used is invalid. Please use correct locator" + e);
				//getScreenShot();
				return false;
			}
		}


		

		public boolean switchToFrameByID(String id) {
			// TODO Auto-generated method stub
			try 
			{			
				driver.switchTo().frame(driver.findElement(By.id(id)));
				return true;
			} 
			catch (NoSuchElementException e) 
			{
				System.err.println("Frame Elements not found" + e);
				//getScreenShot();
				return false;
			}
			catch (InvalidSelectorException e)
			{
				System.err.println("CSS Selector used is invalid. Please use correct locator" + e);
				//getScreenShot();
				return false;
			}
			catch (ElementNotVisibleException e) 
			{
				System.err.println("Element is not visisble" + e);		
				//getScreenShot();
				return false;
			}
		}


		public boolean verifyTextById(String id, String data) {
			// TODO Auto-generated method stub
			try 
			{
				if(driver.findElement(By.id(id)).getText().equalsIgnoreCase((String) data))
				{
					System.out.println("Verified text is" + data);
					return true;
				}
		
				else			
					return false;
			} 
			catch (NoSuchElementException e) 
			{
				System.err.println("Text Element is not found" + e);	
				//getScreenShot();
				return false;
			}
			catch (InvalidSelectorException e)
			{
				System.err.println("CSS Selector used is invalid. Please use correct locator" + e);
				//getScreenShot();
				return false;
			}
			catch (ElementNotVisibleException e) 
			{
				System.err.println("Element is not visisble" + e);		
				//getScreenShot();
				return false;
			}
		

		}


	
		
			
		public boolean verifyTitleContains(String title) {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean acceptAlert() {
			// TODO Auto-generated method stub
			try {
				driver.switchTo().alert().accept();
			} catch (NoAlertPresentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No Alert found");
			}
			return false;
		}


		public String verifyTextById1(String id, String data) {
			// TODO Auto-generated method stub
			return null;
		}

//
//		public boolean clickByCSS(String CSS) {
//			try {
//				driver.findElement(By.cssSelector(CSS)).click();
//				System.out.println("Element successfully clicked using CssSelector locator : " + CSS);
//				//getScreenShot();
//				return true;
//			} catch (InvalidSelectorException e) {
//				System.out.println("Element falied to click using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				//getScreenShot();
//				return false;
//			} catch (NoSuchElementException e) {
//				System.out.println("Element falied to click using CssSelector locator : " + CSS
//						+ ". Element is not found. Please refer the error description");
//				e.printStackTrace();
//				//getScreenShot();
//				return false;
//			} catch (ElementNotVisibleException e) {
//				System.out.println("Element falied to click using CssSelector locator : " + CSS
//						+ ". Element is not visible. Please refer the error description");
//				e.printStackTrace();
//				//getScreenShot();
//				return false;
//			} catch (SessionNotFoundException e) {
//				System.out.println("Element falied to click using CssSelector locator : " + CSS
//						+ ". Session is not found. Please refer the error description");
//				e.printStackTrace();
//				//getScreenShot();
//				return false;
//			}
//		}


//		public boolean enterByCSS(String CSS, String data) 
//		{
//			try {
//				driver.findElement(By.cssSelector(CSS)).sendKeys(data);
//				System.out.println("Value : "+data+ " successfully entered using CssSelector locator : " + CSS);
//				// getScreenShot();
//				return true;
//			}
//
//			catch (InvalidSelectorException e) {
//				System.out.println("Falied to ented value : "+data+" using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//				return false;
//			} catch (NoSuchElementException e) {
//				System.out.println("Falied to ented value : "+data+" using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//				return false;
//			} catch (ElementNotVisibleException e) {
//				System.out.println("Falied to ented value : "+data+" using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//				return false;
//			} //catch (SessionNotFoundException e) {
//				System.out.println("Falied to ented value : "+data+" using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//				return false;
//			}
//		}
//
//
//		public String getTextByCSS(String CSS) {
//			String getText = null;
//			try {
//				getText = driver.findElement(By.cssSelector(CSS)).getText();
//				System.out.println("Successfully got the text using CssSelector locator : " + CSS);
//				// getScreenShot();
//			} catch (InvalidSelectorException e) {
//				System.out.println("Falied to get text using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//			} catch (NoSuchElementException e) {
//				System.out.println("Falied to get text using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//			} catch (ElementNotVisibleException e) {
//				System.out.println("Falied to get text using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//			} catch (SessionNotFoundException e) {
//				System.out.println("Falied to get text using CssSelector locator : " + CSS
//						+ ". Please refer the error description");
//				e.printStackTrace();
//				// getScreenShot();
//			}
//			return getText;
//			
//			
//		}


		public boolean clickByXPath(String XPath) {
			try {
			// TODO Auto-generated method stub
			driver.findElementByXPath(XPath).click();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Could not fine the element with xpath: "+ XPath);
			// getScreenShot();
			return false;
		}
		return true;
	}


		public boolean enterByXPath(String XPath, String data) {
			// TODO Auto-generated method stub
			return false;
		}


		public String getTextByXPath(String XPath) {
			// TODO Auto-generated method stub
			String returnText = null;
			try
			{
				 returnText = driver.findElementByXPath(XPath).getText();
				 System.out.println("Text displayed is "+  returnText);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not fine the element with xpath: "+XPath);
				// getScreenShot();
				return null;
			}
			
			return returnText;
		}


		public String verifyTextByXPath(String XPath, String data) {
			// TODO Auto-generated method stub
			String actualText = null, result = null;
			try {
				actualText = driver.findElementByXPath(XPath).getText();
				if (actualText.equals(data)){
				result = "True";	
				
				}
				else{
					result = "False";
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find the element with xpath: "+ XPath);
				//getScreenShot();
				return null;
			}
			
			return result;
		}


		public Select getDropDownByXPath(String XPath) {
			try {
				WebElement dropdown = driver.findElementByXPath(XPath);
				Select DropDown = new Select(dropdown);
				return DropDown;
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find the element with xpath: "+XPath);
				return null;
			}
		
		
		}


		public boolean verifyTextContainsByXPath(String XPath, String text) {
			// TODO Auto-generated method stub
			
			try {
				String actualText = driver.findElementByXPath(XPath).getText();
				if (actualText.contains(text)){
				return true;	
				
				}
				else{
					return false;
				}
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find the element with xpath: "+ XPath);
				//getScreenShot();
				return false;
			}
			
			
		
		
}


		public boolean switchToFrameByXPath(String XPath) {
			// TODO Auto-generated method stub
			try {
				driver.switchTo().frame(driver.findElementByXPath(XPath));
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find the element by xpath: "+ XPath);
				return false;
			}
			return true;
		}


		public List<WebElement> findAllElementsByXPath(String XPath) {
			// TODO Auto-generated method stub
			List<WebElement> webelements = null;
			try {
				webelements = driver.findElementsByXPath(XPath);
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not fine the elements with xpath"+XPath);
				return null;
			}
			
			return webelements;
		}


		public int countAllElementsByXPath(String XPath) {
			// TODO Auto-generated method stub
			int count = 0;
			try {
				List<WebElement> webelements = driver.findElementsByXPath(XPath);
				count = webelements.size();
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find the element with xpath: "+XPath);
				return 0;
			}
			return count;
		}


		public boolean isEnabledByXPath(String XPath) {
			// TODO Auto-generated method stub
			boolean enabledFlag;
			try {
				enabledFlag = driver.findElementByXPath(XPath).isEnabled();
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Could not find the element with xpath: "+XPath);
				return false;
			}
			return enabledFlag;
		}


		public boolean isVisibleByXPath(String XPath) {
			// TODO Auto-generated method stub
			boolean visibleFlag;
			try {
				visibleFlag = driver.findElementByXPath(XPath).isDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return visibleFlag;
		}


		

		public boolean loginLinkedIn(String userName, String passWord){
			
			try {
				enterById("login-email", userName);
				enterById("login-password", passWord);
				clickByName("submit");
				return true;
			} 
			catch (NoSuchElementException e) 
			{
				System.out.println("Element for User Login is not found");
				e.printStackTrace();
				return false;
			}
		}


		
		public boolean clickByName(String id) {
			try {
				driver.findElementByName(id).click();
				System.out.println("Clicked Name is confirmed");
				return true;
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				System.out.println("No Such Element Found"+id);
				e.printStackTrace();
				return false;
			}
			catch (ElementNotVisibleException e) 
			{
				System.out.println("Element is not visisble" + e);		
				//getScreenShot();
				return false;
			}


			}


//		public String getTextByLinkText(String linktext) {
//			String linkTextValue = null;
//			try {
//				linkTextValue = driver.findElementByLinkText(linktext).getText();
//				
//
//			} catch (NoSuchElementException e) 
//			{
//				System.err.println("Element is not found" + e);	
//				//getScreenShot();
//			}
//
//			catch (ElementNotVisibleException e) 
//			{
//				System.err.println("Element is not visisble" + e);		
//				//getScreenShot();			
//			}
//			return linkTextValue;
//
//		}
		
		
		public String getTextByLinkText(String linktext) {
			String linkTextValue = null;
			try {
				linkTextValue = driver.findElementByLinkText(linktext).getText();
				System.out.println("Text displayed is " + linkTextValue);
				

			} catch (NoSuchElementException e) 
			{
				System.err.println("Element is not found" + e);	
				//getScreenShot();
			}

			catch (ElementNotVisibleException e) 
			{
				System.err.println("Element is not visisble" + e);		
				//getScreenShot();			
			}
			return linkTextValue;

		}


		public boolean clickByLinkText(String linktext) {
			try {
				driver.findElement(By.linkText(linktext)).click();
				return true;
			} catch (NoSuchElementException e) {


				System.out.println("Could not find the link text :"+ linktext);
				//getScreenShot();
				e.printStackTrace();
				return false;
			}


		}


		
		
		public String getTextByClassName(String classname) {
			// TODO Auto-generated method stub
			return null;
		}
		

		public boolean getScreenShot() {
			try {
				File screenShot = driver.getScreenshotAs(OutputType.FILE);
				//File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String file =SSFolder+System.currentTimeMillis()+".JPG";
				FileUtils.copyFile(screenShot, new File(file));
				return true;
			}
			catch (NoSuchElementException e){
				System.out.println("Not able to get Screenshot of the Page because of the ID is not Found: " +e);
				return false;
			}
			catch (IOException e) {
				System.out.println("Not able to save destination path : " +e);
				return false;
			}
		}


//		public String getTextByClassName(String classname) {
//			// TODO Auto-generated method stub
//			try
//			{
//				
//				String getText = driver.findElement(By.className(classname)).getAttribute("value");
//				//getScreenShot();
//				
//				
//			} 
//				
//			catch(NoSuchElementException e)
//			{
//				System.out.println("element not  found : "+classname+ " verify the class name"+e);
//				e.printStackTrace();
//				//getScreenShot();
//			}
//			
//			
//			
//			catch (ElementNotVisibleException e) {
//				System.out.println("Failed to get the Classname locator :"+classname+"  Please refer the error description"+e);
//				e.printStackTrace();
//				//getScreenShot();
//				
//			}
//			catch (SessionNotFoundException e) {
//				System.out.println("failed to locate active session"+e);
//				e.printStackTrace();
//				//getScreenShot();
//			}
//
//			catch(WebDriverException e)
//			{
//				System.out.println(" Web driver has found an error"+e); 
//				e.printStackTrace();
//				//getScreenShot();
//			}
//			finally {}
//			
//			String getText;
//			return getText;
//		}
//
//		
	
}



