package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;

public class stepdefinitions {

	WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@Given("^I am on Justeat.ca application$")
	public void i_am_on_justeat_ca_application() {

		System.out.println("Inside Step - Justeat.ca Browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);

		System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		String baseUrl = "https://www.just-eat.co.uk/";
		driver.get(baseUrl);
		driver.manage().window().maximize();

	}

	@And("I want food in {string}")
	public void i_want_food_in(String string) throws InterruptedException {

		homePage home = new homePage(driver);
		home.handleCookies();
		driver.findElement(By.name("postcode")).sendKeys("WC2N 5DU");

	}

	@When("I search for restaurants")
	public void i_search_for_restaurants() throws InterruptedException {
		homePage home = new homePage(driver);
		home.enter();

	}

	@Then("I should see some restaurants in {string}")
	public void i_should_see_some_restaurants_in(String string) {

		homePage home = new homePage(driver);
		home.validatePostalCode();
		driver.close();
		driver.quit();

	}

}
