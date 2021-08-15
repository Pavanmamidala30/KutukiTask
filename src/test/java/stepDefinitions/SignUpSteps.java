package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.MainUtils;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class SignUpSteps {

	WebDriver driver;

	@Given("^User launches browser and navigate to signup page$")
	public void user_launches_browser_and_navigate_to_signup_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver92.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MainUtils.getProp("URL"));
	}

	@Given("^user is on the signup page and enter all details$")
	public void user_is_on_the_signup_page_and_enter_all_details() throws Throwable {
		MainUtils.inputOnElement(driver, MainUtils.getProp("FirstName.xpath"), MainUtils.getProp("FirstName"));
		MainUtils.inputOnElement(driver, MainUtils.getProp("LastName.xpath"), MainUtils.getProp("LastName"));
		MainUtils.inputOnElement(driver, MainUtils.getProp("Email.xpath"), MainUtils.getProp("Email"));
		MainUtils.inputOnElement(driver, MainUtils.getProp("Phone.xpath"), MainUtils.getProp("PhoneNo"));
		MainUtils.dropDownVisibleText(driver, MainUtils.getProp("GenderDD.xpath"), MainUtils.getProp("Gender"));
		MainUtils.clickOnElement(driver, MainUtils.getProp("Checkbox.xpath"));
		MainUtils.clickOnElement(driver, MainUtils.getProp("Submit.xpath"));
	}

	@When("^registrion process is completed without any error$")
	public void registrion_process_is_completed_without_any_error() throws Throwable {
		MainUtils.waitForElement(driver, MainUtils.getProp("SuccesSignin.xpath"));
		boolean assertionCheck = MainUtils.assertionCheck(driver, MainUtils.getProp("SuccesSignin.xpath"));

		Assert.assertEquals(true, assertionCheck);
	}

	@Then("^user is succesufully registered$")
	public void user_is_succesufully_registered() throws Throwable {
		System.out.println("User Succesfully Registered");
	}

}
