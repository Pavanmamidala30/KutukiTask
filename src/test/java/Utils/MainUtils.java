package Utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainUtils {

	public static String getProp(String property) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src//test//resources//PropertyFiles//Config.properties");
		prop.load(fis);

		String PropValue = prop.getProperty(property);
		return PropValue;
	}

	public static void inputOnElement(WebDriver driver, String xpath, String input) {
		driver.findElement(By.xpath(xpath)).sendKeys(input);

	}

	public static void dropDownVisibleText(WebDriver driver, String ddxpath, String visibletext) {
		WebElement dd = driver.findElement(By.xpath(ddxpath));
		Select s = new Select(dd);
		s.selectByVisibleText(visibletext);
	}

	public static void clickOnElement(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static boolean assertionCheck(WebDriver driver, String Xpath) {
		boolean flag;
		String ActualString = driver.findElement(By.xpath(Xpath)).getText();
		String ExpectedString = "Thank you! Your submission has been received!";
		if (ActualString.equals(ExpectedString)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static void waitForElement(WebDriver driver, String xpath) {

		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

	}

}
