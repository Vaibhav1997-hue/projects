package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/* 1) Open application
 * 3) Entering Special Character in the fields
 * 3) ErrorMessage should be display 
 */

public class Specialcharacter {
	WebDriver driver;

	@Test(priority = 1) // priority default value is zero(0).
	void openapp() {
		System.setProperty("webdriver.chrome.driver", "D:\\java\\loginTest\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://app.germanyiscalling.com/common/login/?next=https%3A%2F%2Fapp.germanyiscalling.com%2Fcv%2Fhome%2F");
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	void logincharacter() {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("@#$%^&");
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("*&^%");
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-danger')]")).click();

	}

	@Test(priority = 3)
	void errormessage() throws InterruptedException {
		WebElement errorMessageElement = driver.findElement(By.xpath(
				"//li[text()='Please enter a correct username and password. Note that both fields may be case-sensitive.']"));
		String actualErrorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Please enter a correct username and password. Note that both fields may be case-sensitive.";
		if (actualErrorMessage.equals(expectedErrorMessage)) { // Comparing actual result with expected result
			System.out.println("Error message is as expected.");
		} else {
			System.out.println("Error message is not as expected. Actual message: " + actualErrorMessage);
		}

		Thread.sleep(10000);
		driver.close();

	}
}
