package sdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

	private WebDriver driver;

	private By bikelight = By.xpath("//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button");
	private By onesie = By.xpath("//*[@id=\"inventory_container\"]/div/div[5]/div[3]/button");
	private By cart = By.xpath("//a[@href=\"./cart.html\"]");
	private By item = By.xpath("//span[@class=\"fa-layers-counter shopping_cart_badge\"]");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addToCart1() {
		driver.findElement(bikelight).click();
	}

	public void addToCart2() {
		driver.findElement(onesie).click();
	}

	public String CheckNumOfItem() {
		String num = driver.findElement(item).getText();
		return num;
	}

	public CartPage ClickOnCartButton() {
		WebElement sub = driver.findElement(cart);
		String script = "arguments[0].scrollIntoView()";
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript(script, sub);
		sub.click();
		return new CartPage(driver);
	}
}
