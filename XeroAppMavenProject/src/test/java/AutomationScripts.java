
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class AutomationScripts extends ReusableMethods {
	
	
	
	public static void Validate_Login_Error_Msg() throws Exception {
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro1=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		createTestScriptReport("Validate_Login_Error_Msg");
         String expData= "Your email or password is incorrect";
         IntializeDriver("Chrome");
 		driver.get(pro1.getProperty("XeroURL"));
 		logger.log(Status.INFO,"Xero Login  page opened");
 		
 		WebElement username=driver.findElement(getLocator("Xero.login.username",objPro));
		enterText(username, "username field","Mayurikale2311@gmail.com");
  		
		WebElement password=driver.findElement(getLocator("Xero.login.password",objPro));
		enterText(password, "password field","absdc");
		
		WebElement loginButton=driver.findElement(getLocator("Xero.loginButton",objPro));
		clickElement(loginButton, "Login Button");
		logger.log(Status.INFO,"login button clicked");
		
		WebElement actuaError=driver.findElement(getLocator("Xero.login.errorMsg",objPro));
		verifyText(actuaError, "error message",expData);
		logger.log(Status.INFO, "Login Error msg is validated");
		closeDriver();
		//Validate Error message:
				/*driver.findElement(By.id("email")).sendKeys("mayurikale2311@gmail.com");
				driver.findElement(By.id("password")).sendKeys("abshc");
				driver.findElement(By.id("submitButton")).click();
				System.out.println(driver.findElement(By.xpath("//div[@class='x-boxed warning']//p")).getText());
				Thread.sleep(3000);
				driver.close();*/
				
		
	}
	
	public static void Validate_Forget_Password() throws Exception{
		
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro2=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		createTestScriptReport("Validate_Forget_Password");
		String expData="To reset your password, enter the email address you use to login to Xero. A link will be emailed to this address which will let you reset your password.";
		IntializeDriver("Chrome");
 		driver.get(pro2.getProperty("XeroURL"));
 		logger.log(Status.INFO,"Xero Login  page opened");
		
 		WebElement username=driver.findElement(getLocator("Xero.login.username",objPro));
		enterText(username, "username field","Mayurikale2311@gmail.com");
		
		WebElement passwordlink=driver.findElement(getLocator("Xero.forgot.link",objPro));
		clickElement(passwordlink, "PasswordLink");
		logger.log(Status.INFO,"Forgot Password Link is  clicked");
		
		WebElement actuaError=driver.findElement(getLocator("Xero.forgotPassword.errorMsg",objPro));
		verifyText(actuaError, "error message",expData);
		logger.log(Status.INFO, "Forgot Password error msg is validated");
		closeDriver();
		//Validate forget password link:
		/*driver.findElement(By.id("email")).sendKeys("mayurikale2311@gmail.com");
		WebElement forget= driver.findElement(By.xpath("//a[@class='forgot-password-advert']"));
		forget.click();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'To reset your password, enter the email address yo')]")).getText());*/
		
	}
	
	
	public static void Validate_GetStarted_Error_msg() throws Exception{
		
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro3=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		createTestScriptReport("Validate_GetStarted_Error_msg");
		String expData= "First name can't be empty";
		
		IntializeDriver("Chrome");
 		driver.get(pro3.getProperty("InitialXeroURL"));
 		logger.log(Status.INFO,"Free Trail  page opened");
 		
 		WebElement freetrail=driver.findElement(getLocator("Xero.freetrail.button",objPro));
		clickElement(freetrail, "FreeTrail");
		logger.log(Status.INFO,"Free Trail button is  clicked");
		
		WebElement getstarted=driver.findElement(getLocator("Xero.getstarted.button",objPro));
		clickElement(getstarted, "GetStarted");
		logger.log(Status.INFO,"Get Started  button is  clicked");
		
		
		WebElement actuaError=driver.findElement(getLocator("Xero.getstarted.errorMsg",objPro));
		verifyText(actuaError, "error message",expData);
		logger.log(Status.INFO, "Get Started Error msg is validated");
		closeDriver();
		
		
       /*driver.get("https://www.xero.com/us/");
		driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@id='signup-form-error-message-1']")).getText());*/
		
	}
	
	
	public static void Validate_Term_Of_Use_Title() throws Exception{
		
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro4=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		String expData="Terms of Use | Xero US";
		createTestScriptReport("Validate_Term_Of_Use_Title");
		IntializeDriver("Chrome");
 		driver.get(pro4.getProperty("InitialXeroURL"));
 		logger.log(Status.INFO,"Term of use page  is opened");
 		
 		WebElement freetrail=driver.findElement(getLocator("Xero.freetrail.button",objPro));
		clickElement(freetrail, "FreeTrail");
		logger.log(Status.INFO,"Free Trail button is  clicked");
 		
 		WebElement termofuse=driver.findElement(getLocator("Xero.termofuse.link",objPro));
		clickElement(termofuse, "TermOfUse");
		logger.log(Status.INFO,"Term of Use Link is  clicked");
		
		 String MainWindow=driver.getWindowHandle();		
 		
		    				
		        Set<String> s1=driver.getWindowHandles();		
		    Iterator<String> i1=s1.iterator();		
		    		
		    while(i1.hasNext())			
		    {		
		        String ChildWindow=i1.next();		
		        		
		        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		        {    		
		             
		                
		                driver.switchTo().window(ChildWindow);	                                                                                                           
		                		
		                             
					//closing the child window
		                    driver.close();		
		        }		
		    }		
		    // Switching to Parent window i.e Main Window.
		        driver.switchTo().window(MainWindow);
		
		        
		        logger.log(Status.INFO,"Term of Use Link is Validated");
		   closeDriver();
		
		//validate term-of-use: child windown open and close and get title of child window
				/*driver.get("https://www.xero.com/us/");
				WebElement term=driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
				   term.click();
				   Thread.sleep(5000);*/		
		    		
		    
		     
	}
	
	
	
	public static  void Validate_Privacy_Link() throws Exception{
		
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro5=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		
		createTestScriptReport("Validate_Privacy_Link");
		IntializeDriver("Chrome");
 		driver.get(pro5.getProperty("InitialXeroURL"));
 		logger.log(Status.INFO,"Privacy Link page is opened");
 		
 		WebElement freetrail=driver.findElement(getLocator("Xero.freetrail.button",objPro));
		clickElement(freetrail, "FreeTrail");
		logger.log(Status.INFO,"Free Trail button is  clicked");
		
 		WebElement privacylink=driver.findElement(getLocator("Xero.Privacy.link",objPro));
		clickElement(privacylink, "PrivacyLink");
		logger.log(Status.INFO,"Privacy  Link is  clicked");
		
		 String MainWindow1=driver.getWindowHandle();		
 		
		    				
		        Set<String> s2=driver.getWindowHandles();		
		    Iterator<String> i2=s2.iterator();		
		    		
		    while(i2.hasNext())			
		    {		
		        String ChildWindow=i2.next();		
		        		
		        if(!MainWindow1.equalsIgnoreCase(ChildWindow))			
		        {    		
		             
		                
		                driver.switchTo().window(ChildWindow);	                                                                                                           
		               		
		                             
					//closing the child window
		                    driver.close();		
		        }		
		    }		
		    // Switching to Parent window i.e Main Window.
		        driver.switchTo().window(MainWindow1);
		
		        
		        logger.log(Status.INFO,"Privacy Link is Validated");
		   closeDriver();
		
		//*WebElement privacy=driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]")
	}
	
	public static void Validate_BookKeeper() throws Exception{
		
		
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro6=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		
		createTestScriptReport("Validate_BookKeeper");
		IntializeDriver("Chrome");
 		driver.get(pro6.getProperty("InitialXeroURL"));
 		logger.log(Status.INFO,"BookKeeper Link page is opened");
 		
 		WebElement freetrail=driver.findElement(getLocator("Xero.freetrail.button",objPro));
		clickElement(freetrail, "FreeTrail");
		logger.log(Status.INFO,"Free Trail button is  clicked");
 		
 		
 		WebElement bookkeeperlink=driver.findElement(getLocator("Xero.BookKeeper.link",objPro));
		clickElement(bookkeeperlink, "BookKeeperLink");
		logger.log(Status.INFO,"BookKeeper Link is  clicked");
		
		
		logger.log(Status.INFO,"BookKeeperLink is Validated");
		   closeDriver();
		
 		 //validate accountant or bookeeper:
        /* WebElement bookkeeper=driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]"));
 		   bookkeeper.click();
 		   Thread.sleep(2000);	
 		   System.out.println(driver.getTitle());
 		   driver.close();*/
		
	}
	
	
	
	public static void Validate_Login_To_Xero() throws Exception{
		
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro7=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		createTestScriptReport("Validate_Login_To_Xero");
		String expData= "First name can't be empty";
		
		IntializeDriver("Chrome");
 		driver.get(pro7.getProperty("XeroURL"));
 		logger.log(Status.INFO,"Login Page is opened");
		
		
 		WebElement username=driver.findElement(getLocator("Xero.login.username",objPro));
		enterText(username, "username field","Mayurikale2311@gmail.com");
		
		WebElement password=driver.findElement(getLocator("Xero.login.password",objPro));
		enterText(password, "password field","xerologin1");
		
		WebElement loginButton=driver.findElement(getLocator("Xero.loginButton",objPro));
		clickElement(loginButton, "Login Button");
		logger.log(Status.INFO,"login button clicked");
		
		
        logger.log(Status.INFO,"User is successfully Logged In");
        
        WebElement logoutlink=driver.findElement(getLocator("Xero.logout.link",objPro));
		clickElement(logoutlink, "LogOutLink");
		logger.log(Status.INFO,"Logout Link is clicked");
		
		WebElement logout=driver.findElement(getLocator("Xero.logout",objPro));
		clickElement(logout, "LogOut");
		logger.log(Status.INFO,"Logout  is clicked");
		
		logger.log(Status.INFO,"User is successfully Logged Out");
        closeDriver();
		
		
		
		
		
		//Login locators:
       
		//driver.get("https://login.xero.com/");
		/*driver.findElement(By.id("email")).sendKeys("mayurikale2311@gmail.com");
		driver.findElement(By.id("password")).sendKeys("xerologin1");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);*/
        
      //Validate logout:
      		/*driver.findElement(By.xpath("//a[@class='username']")).click();
      		Thread.sleep(2000);
      		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();*/
	}
	
	public static void Validate_Add_Organizations() throws Exception{
		
		String propertyPath="./src/test/resources/DataFiles/Configuration.properties";
		Properties pro8=loadPropertyFile(propertyPath);
		
		String objectRepoPath="./src/test/resources/ObjectRepository/ObjectsRepo.properties";
		Properties objPro=loadPropertyFile(objectRepoPath);
		
		
		createTestScriptReport("Validate_Add_Organizations");
		IntializeDriver("Chrome");
 		
		driver.get(pro8.getProperty("XeroURL"));
 		logger.log(Status.INFO,"Login Page is opened");
		
		
 		WebElement username=driver.findElement(getLocator("Xero.login.username",objPro));
		enterText(username, "username field","Mayurikale2311@gmail.com");
		
		WebElement password=driver.findElement(getLocator("Xero.login.password",objPro));
		enterText(password, "password field","xerologin1");
		
		WebElement loginButton=driver.findElement(getLocator("Xero.loginButton",objPro));
		clickElement(loginButton, "Login Button");
		logger.log(Status.INFO,"login button clicked");
		
		logger.log(Status.INFO,"User is successfully Logged In");
		
		WebElement selflink=driver.findElement(getLocator("Xero.SelfLink",objPro));
		clickElement(selflink, "Self Link");
		logger.log(Status.INFO,"Self Link is clicked");
		
		WebElement myxerolink=driver.findElement(getLocator("Xero.MyXeroLink",objPro));
		clickElement(myxerolink, "My Xero Link");
		logger.log(Status.INFO,"My Xero Link is clicked");
		
		WebElement orglink=driver.findElement(getLocator("Xero.orglink",objPro));
		clickElement(orglink, "Login Button");
		logger.log(Status.INFO,"Add organization Link is clicked");
		
		WebElement orgname=driver.findElement(getLocator("Xero.orgname",objPro));
		enterText(orgname, "organizationName field","Self");
		
		WebElement orgfield=driver.findElement(getLocator("Xero.orgfield",objPro));
		enterText(orgfield, "password field","Accounts");
		
		WebElement downlink=driver.findElement(getLocator("Xero.DownLink",objPro));
		clickElement(downlink, "My Xero Link");
		logger.log(Status.INFO,"DropDown Link is clicked");
		
		WebElement wavelink=driver.findElement(getLocator("Xero.waveLink",objPro));
		clickElement(wavelink, "My Xero Link");
		logger.log(Status.INFO,"Wave is selected from the Dropdwon ");
		
		WebElement starttrail=driver.findElement(getLocator("Xero.StartTrailButton",objPro));
		clickElement(starttrail, "StartTrail Button");
		logger.log(Status.INFO,"Start Trail button is clicked");
		
		logger.log(Status.INFO,"Add Organization is Validated");
		
		//Vaidate add organizations:
				/*driver.findElement(By.xpath("//a[contains(text(),'Enenus global')]")).click();
				driver.findElement(By.xpath("//a[@class='myxero-link']")).click();
				driver.findElement(By.xpath("//a[@id='ext-gen1042']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='text-1022-inputEl']")).sendKeys("Self");
				driver.findElement(By.xpath("//input[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounts");
				driver.findElement(By.xpath("//div[@id='ext-gen1119']")).click();
				driver.findElement(By.xpath("//li[contains(text(),'Wave')]")).click();
				driver.findElement(By.xpath("//a[@id='simplebutton-1035']")).click();*/
	}
	
	
	
	
	
	
	
	
	
}





