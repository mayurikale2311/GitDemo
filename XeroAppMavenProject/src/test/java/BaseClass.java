
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public static WebDriver driver=null;
	public static WebDriver IntializeDriver(String name){
		
		if(name.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Anup\\Downloads\\gecko.exe\\gekodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(name.equalsIgnoreCase("chrome")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Anup\\Downloads\\chrome.exe\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(name.equalsIgnoreCase("ie")){
			System.out.println("chrome entered");
			System.setProperty("webdriver.ie.driver","C:\\Users\\Anup\\Downloads\\IE.exe\\IEDriverServer.exe.");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		return driver;
	}
	public static void closeDriver(){
		driver.close();
	}

}