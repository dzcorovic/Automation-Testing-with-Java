package sdemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Base {

	public WebDriver driver;
    
	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	public HomePage hPage() 
	{  
		 HomePage home = new HomePage(driver);
		 return home;
	}

	public void takeScreenshot(String filename) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(srcFile,
					new File(System.getProperty("user.dir") + "\\screenshots\\" + filename + ".png"));
			Reporter.log("<br><img src=' " + srcFile + "' height='200' widht='200'/><br>");
			Reporter.log(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
