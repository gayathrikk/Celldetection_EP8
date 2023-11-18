package Sanity.Cell_annotation;



import java.util.List;

import java.util.Set;
import java.util.logging.Level;
import org.testng.Assert;
import org.testng.AssertJUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;

public class Testing {
	 
	   private RemoteWebDriver driver;
	   private WebDriverWait wait;
		
	    @BeforeTest
	    public void setup() throws Exception {
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.12.20.118:5555/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	        wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
	    }
	    @Parameters("URL")
	    @Test(priority = 1)
	   public void login(@Optional("defaultURL") String URL) 
	    //public void login() 
	    {
	   
	    	driver.get(URL);
	    	//driver.get("https://apollo2.humanbrain.in/viewer/annotation/portal");
			driver.manage().window().maximize();
	        String currentURL = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentURL);
			WebDriverWait wait = new WebDriverWait(driver, 10);
	    	driver.switchTo().defaultContent(); // Switch back to default content
	    	WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
	    	if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
	    	    viewerElement.click();
	    	    System.out.println("Viewer icon is clicked");
	    	} else {
	    	    System.out.println("Viewer icon is not clickable");
	    	}
	    	checkConsoleLog();
	
	        String parentWindow = driver.getWindowHandle();
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
	        if (loginButton != null) {
	            loginButton.click();
	            System.out.println("Login button clicked successfully.");
	        } else {
	            System.out.println("Login button is not clicked.");
	        }
	        checkConsoleLog();
		  wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		  Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                break;
	            }
	        }
	        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
	        if (emailInput != null && emailInput.isDisplayed()) {
	            emailInput.sendKeys("teamsoftware457@gmail.com");
	            System.out.println("Email was entered successfully.");
	        } else {
	           System.out.println("Email was not entered.");
	        }
	        checkConsoleLog();
	
	        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton1 != null) {
	            nextButton1.click();
	            System.out.println("Next button 1 is clicked.");
	        } else {
	            System.out.println("Next button 1 is not clicked.");
	        }
	        checkConsoleLog();
	        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
	        passwordInput.sendKeys("Health#123");
	        if (passwordInput.getAttribute("value").equals("Health#123")) {
	            System.out.println("Password was entered successfully.");
	        } else {
	            System.out.println("Password was not entered.");
	        }
	        checkConsoleLog();
	        
	        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
	        if (nextButton2 != null) {
	            nextButton2.click();
	            System.out.println("Next button 2 is clicked.");
	        } else {
	            System.out.println("Next button 2 is not clicked.");
	        }
	        checkConsoleLog();
	
	        driver.switchTo().window(parentWindow);
	        System.out.println("Login successfully");
	        checkConsoleLog();
	        Loginpage_API();
	        System.out.println("************************Login validation done***********************");
	    }

	    @Test(priority=2)
		public void series_set() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, 30); 
			driver.switchTo().defaultContent();
	
			
	    	 try {
	    		    WebElement Mouse = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[6]")));
	    		    Mouse.click();
	    		    System.out.println("Human Fetus clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Human Fetus not clicked: " + e.getMessage());
	    		}
	    	 checkConsoleLog();
	    	 
	    	 try {
	    		    WebElement Brain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[7]//td[2]")));
	    		    Brain.click();
	    		    System.out.println(" Brain clicked successfully.");
	    		    Thread.sleep(2000);
	    		} catch (Exception e) {
	    		    System.out.println("Brain not clicked: " + e.getMessage());
	    		}
	    	 checkConsoleLog();
	    	 
	    	 try {
	 		    WebElement MTB_10 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='cdk-table nb-tree-grid']//tr[25]//td[3]")));
	 		    MTB_10.click();
	 		    System.out.println("FTB-40 clicked successfully.");
	 		    Thread.sleep(2000);
	 		} catch (Exception e) {
	 		    System.out.println(" FTB-40 not clicked: " + e.getMessage());
	 		}
	    	 checkConsoleLog();
	    	 
	    	 try {
	  		    WebElement section = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='712'])[1]")));
	  		    section.click();
	  		    System.out.println("section clicked successfully.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("section not clicked: " + e.getMessage());
	  		}
	    	 
	    	 checkConsoleLog();
	    	 seriesset_API();
	    	 System.out.println("************************************Series set validation done********************************");
	
	    	 
		}

	    @Test(priority = 3)
	    public void cellannotation() {
	    	
	    	driver.switchTo().defaultContent();
	    	try {
	  		    WebElement contributor= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Cell Annotation']")));
	  		    contributor.click();
	  		    System.out.println("cell annotation page opened.");
	  		    Thread.sleep(2000);
	  		} catch (Exception e) {
	  		    System.out.println("Cell annotation is not open: " + e.getMessage());
	  		}
		 checkConsoleLog();
	     Cell_API();
	     System.out.println("****************Cell annotation page open successfully*******************");
	    }
	      @Test(priority=4)
	      public void Tileloading()
	      {
	    	    driver.switchTo().defaultContent();
	    	    clickElementByXpath("(//nb-icon[@pack='nebular-essentials'])[6]", "Goto option");
			    
			    WebElement tileNumberInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Tile Number']")));
		        tileNumberInput.sendKeys("5731");
		        
		        clickElementByXpath("//button[text()='Go to']", "Goto Button option");
		        clickElementByXpath("//a[@title='Tile Annotation']", "Tile annotation page");
		       
		        WebDriverWait wait = new WebDriverWait(driver, 100); // Wait for up to 60 seconds

		        try {
		            WebElement toaster1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Annotated Data loaded successfully']")));
		            String Toaster1 = toaster1.getText();
		            String Expected1 = "Annotated Data loaded successfully";
		            Assert.assertEquals(Expected1, Toaster1);
		        } catch (TimeoutException e) {
		            // At least one of the expected toasters did not appear within 1 minute; fail the test.
		            Assert.fail("Toaster message did not appear within the expected time.");
		        }


		        checkConsoleLog();
		        tileloading_API();
		        System.out.println("************Tile loaded successfully**************");
		        
		  }
	    
		@Test(priority=5)

		  public void centroidDetection() throws InterruptedException {
			
			  driver.switchTo().defaultContent();
			  clickElementByXpath("(//select[@status='primary'])[2]", "Algorithym option"); 
			  clickElementByXpath("//option[text()=' CentroidDetection ']", "Centroid Detection");
			  
			  Thread.sleep(6000);
			  WebElement toast2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']")));
			  String actualFileName2 = toast2.getText();
			  String expectedFileName2 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName2,actualFileName2);
			  checkConsoleLog();
			  Centroiddetection_API();
			  System.out.println("****************EP4 firstpass Relearn success***********************");
			  Thread.sleep(5000);

		  }

		@Test(priority=6)
		public void celldetection() throws InterruptedException
		{
			driver.switchTo().defaultContent();
			clickElementByXpath("(//select[@status='primary'])[2]", "Algorithym option"); 
			clickElementByXpath("//option[text()=' CellDetection ']", "Cell Detection");
	
			  Thread.sleep(6000);
			  WebElement toast2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']")));
			  String actualFileName2 = toast2.getText();
			  String expectedFileName2 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName2, actualFileName2);
			  checkConsoleLog();
			  Celldetection_API();
			  System.out.println("****************EP1 firstpass Relearn success*****************");
			  Thread.sleep(5000);
		}

		  @Test(priority=7)

		  public void Rabies() throws InterruptedException {
			  
			  driver.switchTo().defaultContent();
			  clickElementByXpath("(//select[@status='primary'])[2]", "Algorithym option"); 
			  clickElementByXpath("//option[text()=' Rabies ']", "Rabies");
			  driver.findElement(By.xpath("//option[text()=' Rabies ']")).click();
			  Thread.sleep(6000);
			  WebElement toast3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nb-toast//span[text()='Relearn']/following-sibling::div[@class='message']")));
			  String actualFileName3 = toast3.getText();
			  String expectedFileName3 = "Relearn success"; 
			  Assert.assertEquals(expectedFileName3, actualFileName3);
			  checkConsoleLog();
			  Rabbies_API();
			  System.out.println("************EP7 firstpass Relearn success************");
			  Thread.sleep(5000);
		  }
		  @Test(priority=8)

		  public void Annotation() throws InterruptedException {
			 
			  driver.switchTo().defaultContent();
			  clickElementByXpath("//a[@title='Annotation']", "Annotation"); 
			  clickElementByXpath("//a[@title='Clear and Add  First Pass']", "Clear And Add Firstpass"); 
			  checkConsoleLog();
			  Thread.sleep(2000);
			  System.out.println("***********Cleared and First pass added**************");
			  Thread.sleep(5000);
		  }

		  @Test(priority=9)

		  public void save() throws InterruptedException {
			  
			  driver.switchTo().defaultContent();
			  clickElementByXpath("//a[@title='Actions']", "Action"); 
			  clickElementByXpath("//a[@title='Save']", "save"); 
			  Thread.sleep(2000);
			 WebElement toast4 = driver.findElement(By.xpath("//nb-toast//span[text()='Save']/following-sibling::div[@class='message']"));
			  String actualFileName4 = toast4.getText();
			  String expectedFileName4 = "Saved Successfullly"; 
			  Assert.assertEquals(actualFileName4, expectedFileName4);
			  checkConsoleLog();
			  Save_API();
			  System.out.println("******************Annotation Saved Successfully******************");
			  Thread.sleep(3000);
		  }
		  private void clickElementByXpath(String xpath, String elementName) {
		        try {
		        	WebDriverWait wait = new WebDriverWait(driver, 30);
		            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		            element.click();
		            System.out.println(elementName + " clicked");
		            Thread.sleep(2000);
		        } catch (Exception e) {
		            System.out.println(elementName + " not clicked: " + e.getMessage());
		        }
			}
		  private void Loginpage_API()
		    {	
		    	//getLoginUser API
		    	 String jsonBody = "{\"user_name\":\"software team\",\"user_hash\":\"106900966448254245591\",\"email\":\"teamsoftware457@gmail.com\",\"image\":\"https://lh3.googleusercontent.com/a/ACg8ocJ98wDtdlOS-ADlQ2n_WnL1iY7vWcGr8bWfkxU-9ntv=s96-c\"}";
		    	 Response response = RestAssured
		             .given()
		                 .auth()
		                 .preemptive()
		                 .basic("admin", "admin")
		                 .contentType(ContentType.JSON)
		                 .body(jsonBody)
		             .when()
		                 .post("https://apollo2.humanbrain.in/CC/getLoginUser");
		    	 int statusCode = response.getStatusCode();
		    	 if (statusCode == 200) {
		             System.out.println("API request to getLoginUser passed. Status code: " + statusCode);
		         } else {
		             System.out.println("API request to getLoginUser failed. Status code: " + statusCode);
		         }
		         Assert.assertEquals(statusCode, 200, "API request to getLoginUser failed");
		         
		        //Activity API
		         String jsonBody1 = "{\"user\":\"124\",\"action\":\"Login\",\"info\":\" \"}";
		    	 Response response1 = RestAssured
		             .given()
		                 .auth()
		                 .preemptive()
		                 .basic("admin", "admin")
		                 .contentType(ContentType.JSON)
		                 .body(jsonBody1)
		             .when()
		                 .post("https://apollo2.humanbrain.in/activities/Activity/");
		    	 int statusCode1 = response1.getStatusCode();
		    	 if (statusCode1 == 201) {
		             System.out.println("API request to Activity passed. Status code: " + statusCode1);
		         } else {
		             System.out.println("API request to Activity failed. Status code: " + statusCode1);
		         }
		    	 Assert.assertEquals(statusCode1, 201, "API request to Activity failed");   
		         
		         
		    }
		  private void seriesset_API()
		    {	
		    	//series set
		    	 Response response = RestAssured.get("https://apollo2.humanbrain.in/CC/getDetailsOfSeriesStatsAllRestricted/106900966448254245591");
		         int statusCode = response.getStatusCode();
		         if (statusCode == 200) {
		             System.out.println("API request to the series set page passed. Status code: " + statusCode);
		         } else {
		             System.out.println("API request to the series set failed. Status code: " + statusCode);
		         }
		         Assert.assertEquals(statusCode, 200, "API request to the series set failed");
		         
		         
		         //Brain access activity
		         String jsonBody1 = "{\"user\":124,\"action\":\"Brain Access\",\"info\":\"Brain Id - 16\"}";
		    	 Response response1 = RestAssured
		             .given()
		                 .auth()
		                 .preemptive()
		                 .basic("admin", "admin")
		                 .contentType(ContentType.JSON)
		                 .body(jsonBody1)
		             .when()
		                 .post("https://apollo2.humanbrain.in/activities/Activity/");
		    	 int statusCode1 = response1.getStatusCode();
		    	 if (statusCode1 == 201) {
		             System.out.println("API request to Brainaccess Activity passed. Status code: " + statusCode1);
		         } else {
		             System.out.println("API request to Brainaccess Activity failed. Status code: " + statusCode1);
		         }
		         Assert.assertEquals(statusCode1, 201, "API request to Activity failed");  
		         
		         //Get thumbnails details
		         Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainThumbNailDetails/IIT/V1/SS-16:-1:-1");
		         int statusCode2 = response2.getStatusCode();
		         if (statusCode2 == 200) {
		             System.out.println("API request to the thumbnails details of series set page passed. Status code: " + statusCode2);
		         } else {
		             System.out.println("API request to the thumbnails details of series set failed. Status code: " + statusCode2);
		         }
		         Assert.assertEquals(statusCode2, 200, "API request to the thumbnails details of series set failed");
		         
		         //Get brain viewer deatils
		         Response response3 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-16:-1:-1");
		         int statusCode3 = response3.getStatusCode();
		         if (statusCode3 == 200) {
		             System.out.println("API request to the brain viewer details of series set page passed. Status code: " + statusCode3);
		         } else {
		             System.out.println("API request to the brain viewer details of series set failed. Status code: " + statusCode3);
		         }
		         Assert.assertEquals(statusCode3, 200, "API request to the brain viewer details of series set failed");
		         
		    }
		  private void Cell_API()
		    {
		    	//App atlas Registration
		    	Response response1 = RestAssured
		    		    .given()
		    		    .auth()
		    		    .basic("admin", "admin")
		    		    .when()
		    		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/22992/");
		      int statusCode1 = response1.getStatusCode();
		      if (statusCode1 == 200) {
		          System.out.println("API request to the appatlas registration of Cell annotation passed. Status code: " + statusCode1);
		      } else {
		          System.out.println("API request to the appatlas registration of Cell annotation failed. Status code: " + statusCode1);
		      }
		      Assert.assertEquals(statusCode1, 200, "API request to the appatlas registration of Cell annotation failed");
		      
		      //Get brain viewer details
		      Response response2 = RestAssured.get("https://apollo2.humanbrain.in/GW/getBrainViewerDetails/IIT/V1/SS-16:12:382");
		      int statusCode2 = response2.getStatusCode();
		      if (statusCode2 == 200) {
		          System.out.println("API request to the brain viewer details of cell annotation passed. Status code: " + statusCode2);
		      } else {
		          System.out.println("API request to the brain viewer details of cell annotation failed. Status code: " + statusCode2);
		      }
		      Assert.assertEquals(statusCode2, 200, "API request to the brain viewer details of cell annotation failed");
		      
		      //App annotation type
		      Response response3 = RestAssured
		  		    .given()
		  		    .auth()
		  		    .basic("admin", "admin")
		  		    .when()
		  		    .get("https://apollo2.humanbrain.in/BR/AppAnnotationType/");
		      
		    int statusCode3 = response3.getStatusCode();
		    if (statusCode3 == 200) {
		        System.out.println("API request to get app annotation type details of Cell annotation page passed. Status code: " + statusCode3);
		    } else {
		        System.out.println("API request to get app annotation type details of Cell annotation page failed. Status code: " + statusCode3);
		    }
		    Assert.assertEquals(statusCode3, 200, "API request to get app annotation type details of Cell annotation page failed");
		      
		       //Contributors
		    Response response4 = RestAssured
		  		    .given()
		  		    .auth()
		  		    .basic("admin", "admin")
		  		    .when()
		  		    .get("https://apollo2.humanbrain.in/BR/AppAtlasRegisteration/?externalkey=PixelAnnotation::IIT:V1:SS-16:12:382:382&annotationtype=3");    
		    
			  int statusCode4 = response4.getStatusCode();
			  if (statusCode4 == 200) {
			      System.out.println("API request to get contributors details of cell annotation passed. Status code: " + statusCode4);
			  } else {
			      System.out.println("API request to get contributors details of cell annotation failed. Status code: " + statusCode4);
			  }
			  Assert.assertEquals(statusCode4, 200, "API request to get contributors details of Cell annotation failed");
			  
			  //Annotated tile list
			  String jsonBody1 = "{\"bid\":52,\"sec\":382,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
			   	 Response response5 = RestAssured
			            .given()
			                .auth()
			                .preemptive()
			                .basic("admin", "admin")
			                .contentType(ContentType.JSON)
			                .body(jsonBody1)
			            .when()
			                .post("https://apollo2.humanbrain.in/GW/listAnnotatedTiles");
			   	 int statusCode5 = response5.getStatusCode();
			   	 if (statusCode5 == 200) {
			            System.out.println("API request to list of annotated tiles  passed. Status code: " + statusCode5);
			        } else {
			            System.out.println("API request to list of annotated tiles failed. Status code: " + statusCode5);
			        }
			        Assert.assertEquals(statusCode5, 200, "API request to list of annotated tiles failed");  
			        
			        //WIP tile list
			        String jsonBody2 = "{\"bid\":52,\"sec\":382,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
				   	 Response response6 = RestAssured
				            .given()
				                .auth()
				                .preemptive()
				                .basic("admin", "admin")
				                .contentType(ContentType.JSON)
				                .body(jsonBody2)
				            .when()
				                .post("https://apollo2.humanbrain.in/GW/listWipTiles");
				   	 int statusCode6 = response6.getStatusCode();
				   	 if (statusCode6 == 200) {
				            System.out.println("API request to list of wip tiles  passed. Status code: " + statusCode6);
				        } else {
				            System.out.println("API request to list of wip tiles failed. Status code: " + statusCode6);
				        }
				        Assert.assertEquals(statusCode6, 200, "API request to list of wip tiles failed");  
				        
				     //AG tile list
				        String jsonBody3 = "{\"bid\":52,\"sec\":382,\"annotationtype\":3,\"seriestype\":\"NISSL\",\"tilesize_ip\":\"512\",\"tilesize_op\":512}";
					   	 Response response7 = RestAssured
					            .given()
					                .auth()
					                .preemptive()
					                .basic("admin", "admin")
					                .contentType(ContentType.JSON)
					                .body(jsonBody3)
					            .when()
					                .post("https://apollo2.humanbrain.in/GW/listWipTiles");
					   	 int statusCode7 = response7.getStatusCode();
					   	 if (statusCode7 == 200) {
					            System.out.println("API request to list of AG tiles  passed. Status code: " + statusCode7);
					        } else {
					            System.out.println("API request to list of AG tiles failed. Status code: " + statusCode7);
					        }
					        Assert.assertEquals(statusCode7, 200, "API request to list of AG tiles failed");    
			  
			   
			    }
		  private void tileloading_API()
		  {
			  Response response1 = RestAssured
		    		    .given()
		    		    .auth()
		    		    .basic("admin", "admin")
		    		    .when()
		    		    .get("https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg");
		      int statusCode1 = response1.getStatusCode();
		      if (statusCode1 == 200) {
		          System.out.println("API request to the tile loading passed. Status code: " + statusCode1);
		      } else {
		          System.out.println("API request to the tile loading failed. Status code: " + statusCode1);
		      }
		      Assert.assertEquals(statusCode1, 200, "API request to the tile loading failed");
		  }
		  
		 private void  Celldetection_API()
		 {
			 
	    	 Response response1 = RestAssured
	             .given()
	                 .auth()
	                 .preemptive()
	                 .basic("admin", "admin")
	                 .formParam("iipsrv", "https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg")
	             .when()
	                 .post("https://apollo2.humanbrain.in/ml/predictions/ep1");
	    	 int statusCode1 = response1.getStatusCode();
	    	 if (statusCode1 == 200) {
	             System.out.println("API request to cell detection firstpass passed. Status code: " + statusCode1);
	         } else {
	             System.out.println("API request to cell detection firstpass failed. Status code: " + statusCode1);
	         }
	         Assert.assertEquals(statusCode1, 200, "API request to cell detection firstpass failed");  
		 }
		
		 private void Centroiddetection_API()
		 {
			 Response response1 = RestAssured
		             .given()
		                 .auth()
		                 .preemptive()
		                 .basic("admin", "admin")
		                 .formParam("iipsrv", "https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg")
		             .when()
		                 .post("https://apollo2.humanbrain.in/ml/predictions/ep4");
		    	 int statusCode1 = response1.getStatusCode();
		    	 if (statusCode1 == 200) {
		             System.out.println("API request to centroid detection firstpass passed. Status code: " + statusCode1);
		         } else {
		             System.out.println("API request to centroid detection firstpass failed. Status code: " + statusCode1);
		         }
		         Assert.assertEquals(statusCode1, 200, "API request to centroid detection firstpass failed");  
			 
		 }
		 
		 private void Rabbies_API()
		 {
			 Response response1 = RestAssured
		             .given()
		                 .auth()
		                 .preemptive()
		                 .basic("admin", "admin")
		                 .formParam("iipsrv", "https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/52/NISL/B_52_MTB10-SL_63-ST_NISL-SE_382_lossless.jp2&GAM=1.5&WID=512&RGN=0.5900970787712221,0.37366201751540706,0.02269604149120085,0.02075900097307817&CVT=jpeg")
		             .when()
		                 .post("https://apollo2.humanbrain.in/ml/predictions/ep7");
		    	 int statusCode1 = response1.getStatusCode();
		    	 if (statusCode1 == 200) {
		             System.out.println("API request to centroid detection firstpass passed. Status code: " + statusCode1);
		         } else {
		             System.out.println("API request to centroid detection firstpass failed. Status code: " + statusCode1);
		         }
		         Assert.assertEquals(statusCode1, 200, "API request to centroid detection firstpass failed");  
		 }
		 
		 private void Save_API()
		 {
			 File file = new File("src/test/resource/celldetectionSaveapi.txt");
			 Response response1 = RestAssured
					 .given()
			            .auth()
			            .preemptive()
			            .basic("admin", "admin")
			            .contentType(ContentType.JSON) 
			            .body(file)
		             .when()
		                 .post("https://apollo2.humanbrain.in/GW/save_pixel_additions_status_wp");
		    	 int statusCode1 = response1.getStatusCode();
		    	 if (statusCode1 == 200) {
		             System.out.println("API request to save passed. Status code: " + statusCode1);
		         } else {
		             System.out.println("API request to save firstpass failed. Status code: " + statusCode1);
		         }
		         Assert.assertEquals(statusCode1, 200, "API request to save firstpass failed");  
		 }
		 
		  private void checkConsoleLog() {
		        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		        List<LogEntry> logs = logEntries.filter(Level.SEVERE);
		
		        int severeLogCount = logs.size();
		        System.out.println("Number of SEVERE-level logs: " + severeLogCount);
		
		        for (LogEntry log : logs) {
		            System.out.println("Level is : \n" + log.getLevel());
		            System.out.println("Message is : \n" + log.getMessage());
		        }
		        }
		  
		  @AfterTest

		  public void afterTest() {

			  driver.quit();

		  }
		

}
