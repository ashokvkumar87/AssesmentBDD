package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class homePage {

	protected WebDriver driver;

	private By postalCode = By.name("postcode");

	private By searchButton = By.xpath("//button[@aria-label='Search']");

	private By handleCookies = By.xpath("//button[@data-test-id='accept-all-cookies-button']");
	
	private By clickRandom = By.xpath("(//div[@class='c-appsBanner-image']");
	
	private By validate = By.xpath("(//h1[@class='c-locationHeader-title'])[1]");
	
	

	public homePage(WebDriver driver) {
		this.driver = driver;

	}

	public void enterpostalCode(String postalcode) {

		driver.findElement(postalCode).sendKeys("WC2N 5DU");		
	}

	public void clickSearchButton() {

		driver.findElement(searchButton).click();
	}
	
	
	public void handleCookies() {

		driver.findElement(handleCookies).click();
	}
	
	public void clickRandom() {

		driver.findElement(clickRandom).click();
	}
	
	public void enter() {

		driver.findElement(postalCode).sendKeys(Keys.RETURN);
	}

	public void validatePostalCode() {
		String str = driver.findElement(validate).getText();
		String Actual = str.substring(0,str.indexOf(","));
		String Expected = ("WC2N 5DU");
		assertEquals(Actual, Expected);
	}
}