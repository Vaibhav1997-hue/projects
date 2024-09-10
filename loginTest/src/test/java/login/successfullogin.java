package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/* 1) Open application
 * 3) Login
 * 3) Login Page Should be open 
 */

public class successfullogin {
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
	void login() {
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("vaibhavkhondekar@gmail.com");
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("Vaibhav@19");
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-danger')]")).click();
	}

	@Test(priority = 3)
	void LoginPage() throws InterruptedException {
		String CurrentURL = driver.getCurrentUrl();
		String expectedURL = "https://app.germanyiscalling.com/cv/upload/";
		if (CurrentURL.equals(expectedURL)) { // Comparing actual result with expected result
			System.out.println("Login Page is Successfully Open");
		} else {
			System.out.println("URL does not match. Current URL: " + CurrentURL);
		}

		Thread.sleep(10000);
		driver.close();
	}
}
