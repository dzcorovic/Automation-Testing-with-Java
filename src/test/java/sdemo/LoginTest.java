package sdemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(sdemo.ListenerTest.class)
public class LoginTest extends Base {

	@BeforeClass
	public void setUp() {
		initialization();
	}

	@Test(priority = 0)
	public void loginWithoutUserAndPass() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickSubmitButton();
		Thread.sleep(3000);
		takeScreenshot("test1");
		System.out.println(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText());
		driver.navigate().refresh();
	}

	@Test(priority = 1)
	public void loginWithoutUsername() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.fillPasswordField("secret_sauce");
		home.clickSubmitButton();
		Thread.sleep(3000);
		takeScreenshot("test2");
		System.out.println(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText());
		driver.navigate().refresh();
	}

	@Test(priority = 2)
	public void loginWithoutPassword() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.fillUsernameField("standard_user");
		Thread.sleep(3000);
		home.clickSubmitButton();
		Thread.sleep(3000);
		takeScreenshot("test3");
		System.out.println(driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText());
		driver.navigate().refresh();

	}

	@Test(priority = 3)
	public void login() throws InterruptedException {

		HomePage home = new HomePage(driver);
		home.login("standard_user", "secret_sauce");

		DashboardPage dpage = new DashboardPage(driver);
		dpage.addToCart1();
		Assert.assertEquals(dpage.CheckNumOfItem(), "1", "Number of items in cart are not 1.");
		Thread.sleep(2000);
		dpage.addToCart2();
		Assert.assertEquals(dpage.CheckNumOfItem(), "2", "Number of items in cart are not 2.");
		Thread.sleep(2000);

		dpage.ClickOnCartButton();
		CartPage cpage = new CartPage(driver);
		Thread.sleep(2000);
		Assert.assertEquals(cpage.bikeLightName(), "Sauce Labs Bike Light",
				"Sauce Labs Bike Light is not added on your cart.");
		Assert.assertEquals(cpage.bikeLightQuantity(), "1", "Sauce Labs Bike Light has not quantity 1.");
		Assert.assertEquals(cpage.bikeLightPrice(), "9.99", "Sauce Labs Bike Light has not expected price.");

		Assert.assertEquals(cpage.onesieName(), "Sauce Labs Onesie", "Sauce Labs Onesie is not added on your cart.");
		Assert.assertEquals(cpage.onesieQuantity(), "1", "Sauce Labs Onesie has not quantity 1.");
		Assert.assertEquals(cpage.onesiePrice(), "7.99", "Sauce Labs Onesie has not expected price.");

		System.out.println("Sauce Labs Bike Light item  has price 9.99 and quantity 1");
		System.out.println("Sauce Labs Onesie item has price 7.99 and quanity 1");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
