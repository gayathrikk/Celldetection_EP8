package Sanity.Cell_annotation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CellDetection_EP8 {
	
			private RemoteWebDriver driver;
			
			@BeforeTest
			
			public void setup() throws MalformedURLException 
			{
				
				  DesiredCapabilities dc = DesiredCapabilities.chrome();
			        URL url = new URL("http://172.20.23.7:5555/wd/hub");
			        driver = new RemoteWebDriver(url, dc);
			
			}
		
	  @Test(priority=1)
	  public void Login() throws InterruptedException {
			
			driver.get("http://apollo2.humanbrain.in/");
			driver.manage().window().maximize();
			System.out.println("The server Opened");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ng-tns-c93-3')]")));
			viewerSectionLink.click();
			System.out.println("The Viewer Icon is clicked");
			String parentWindow = driver.getWindowHandle();
			WebDriverWait wait1 = new WebDriverWait(driver, 20);
			WebElement login = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
			login.click();
			System.out.println("The login Button is clicked");
			Thread.sleep(4000);
			Set<String> allWindows = driver.getWindowHandles();
			for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
			driver.switchTo().window(window);
			break;
			}
			}
			Thread.sleep(4000);
			WebDriverWait wait2 = new WebDriverWait(driver,20);
			WebElement  emailInput = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
			emailInput.sendKeys("teamsoftware457@gmail.com");
			System.out.println("Mail I'd is entered");
			WebDriverWait wait3 = new WebDriverWait(driver,20);
			WebElement  Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
			Next.click();
			System.out.println("The Next Button is clicked");
			WebDriverWait wait4 = new WebDriverWait(driver,20);
			WebElement  PasswordInput = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
			PasswordInput.sendKeys("Health#123");
			System.out.println("Password is entered");
			WebDriverWait wait5 = new WebDriverWait(driver,20);
			WebElement  Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
			Next2.click();
			System.out.println("The Next Button is clicked");
			Thread.sleep(5000);
			driver.switchTo().window(parentWindow);
			Thread.sleep(5000);
			}
			
	  @Test(priority=2)
		public void series_set() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
	
			
	    	 try {
	    		    WebElement Mouse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[6]")));
	    		    Mouse.click();
	    		    System.out.println("Human Fetus clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Human Fetus not clicked: " + e.getMessage());
	    		}
	    	
	    	 
	    	 try {
	    		    WebElement Brain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[7]//td[2]")));
	    		    Brain.click();
	    		    System.out.println(" Brain clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Brain not clicked: " + e.getMessage());
	    		}
	    	 
	    	 
	    	 try {
	 		    WebElement MTB_10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@role='grid']//tr[25]//td[3]")));
	 		    MTB_10.click();
	 		    System.out.println("FTB-40 clicked successfully.");
	 		    Thread.sleep(2000);
	 		} catch (Exception e) {
	 		    System.out.println(" FTB-40 not clicked: " + e.getMessage());
	 		}
	    	 
	    	 
	    	 String parentWindow = driver.getWindowHandle();
	    	 try {
		 		    WebElement viewericon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Viewer']")));
		 		   viewericon.click();
		 		    System.out.println("viewer icon is clicked successfully.");
		 		    Thread.sleep(2000);
		 		} catch (Exception e) {
		 		    System.out.println(" viewer icon is not clicked: " + e.getMessage());
		 		}
	    	 
	    	 wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			  Set<String> allWindows = driver.getWindowHandles();
		        for (String window : allWindows) {
		            if (!window.equals(parentWindow)) {
		                driver.switchTo().window(window);
		                break;
		            }
		        }
	    	 
	    	 try {
	  		    WebElement section = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='883'])[1]")));
	  		    section.click();
	  		    System.out.println("section clicked successfully.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("section not clicked: " + e.getMessage());
	  		}
	    	 
	    
	    	 System.out.println("************************************Series set validation done********************************");
	
	    	 
		}
			
	 @Test(priority=3)
	  public void celldetection()
			{
		 
			try {
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table5 = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cell Annotation']")));
			Thread.sleep(3000);
			table5.click();
			System.out.println("The Cellannotation icon is clicked");
			}
			catch(Exception e) {
			System.out.println("The Cellannotation icon is not click");
			}
			try {
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table5 = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='exampleFormControlSelect1'])[2]")));
			Thread.sleep(3000);
			table5.click();
			System.out.println("The dropdown list visible");
			}
			catch(Exception e) {
			System.out.println("The dropdown list is not visible");
			}
			try {
			WebDriverWait wait10 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table5 = wait10.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()=' hover_net ']")));
			Thread.sleep(3000);
			table5.click();
			System.out.println("The hover net is is selected");
			}
			catch(Exception e) {
			System.out.println("The hover net is not selected");
			}
			try {
			WebDriverWait wait11 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table6 = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-accordion-item-header[text()=' Go To ']")));
			Thread.sleep(3000);
			table6.click();
			System.out.println("The Go To icon is clicked");
			}
			catch(Exception e) {
			System.out.println("The Go To icon is not click");
			}
			}
	  @Test(priority=4)
	  public void Goto()
			{
		  
			try {
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table8 = wait13.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Tile Number']")));
			Thread.sleep(3000);
			table8.sendKeys("5000\n");
			table8.click();
			System.out.println("The Go To icon is clicked");
			}
			catch(Exception e) {
			System.out.println("The Go To icon is not click");
			}
			try {
			WebDriverWait wait12 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table7 = wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Go to']")));
			Thread.sleep(3000);
			table7.click();
			System.out.println("The Go To icon is clicked");
			}
			catch(Exception e) {
			System.out.println("The Go To icon is not click");
			}
			}
			
	  @Test(priority=5)
	  public void Tileannotation()
			{
		  
			try {
			WebDriverWait wait13 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table9 = wait13.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/tileanotation.svg']")));
			Thread.sleep(3000);
			table9.click();
			System.out.println("The Tile annotation icon is clicked");
			}
			catch(Exception e) {
			System.out.println("The Tile annotation icon is not click");
			}
			try {
			WebDriverWait wait14 = new WebDriverWait(driver,30);
			Thread.sleep(3000);
			WebElement table101 = wait14.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Annotated Data Failed copying first pass data ']")));
			Thread.sleep(3000);
			String z = table101.getText();
			Thread.sleep(3000);
			System.out.println(z);
			String expectedT11 = "Annotated Data Failed copying first pass data";
			         Assert.assertEquals(z, expectedT11);
			System.out.println("Annotated Data Failed copying first pass data");
			}
			catch(Exception e) {
			System.out.println("Annotated Data Failed copying first pass data *Not SHown*");
			}
			}
	  
   	@AfterTest
	public void tearDown() {
   		
			if (driver != null) 
			{
			driver.quit();
			}
			}
			
		
		}
