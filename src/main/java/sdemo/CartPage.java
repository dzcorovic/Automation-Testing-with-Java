package sdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	private By item_name1 = By.xpath("//*[@id=\"item_0_title_link\"]/div");
	private By item_quantity1 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]");
	private By item_price1 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
	private By item_name2 = By.xpath("//*[@id=\"item_2_title_link\"]/div");
	private By item_quantity2 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[1]");
	private By item_price2 = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");

	public String bikeLightName() {
		return driver.findElement(item_name1).getText();
	}

	public String bikeLightQuantity() {
		return driver.findElement(item_quantity1).getText();
	}

	public String bikeLightPrice() {
		return driver.findElement(item_price1).getText();
	}

	public String onesieName() {
		return driver.findElement(item_name2).getText();
	}

	public String onesieQuantity() {
		return driver.findElement(item_quantity2).getText();
	}

	public String onesiePrice() {
		return driver.findElement(item_price2).getText();
	}
}
