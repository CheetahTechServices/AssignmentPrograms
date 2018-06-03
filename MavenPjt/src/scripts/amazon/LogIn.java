package scripts.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LogIn {
	
	@Test
	void Login() {
		System.setProperty("webdriver.gecko.driver", "./driver.geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		WebElement loginBtn = driver.findElement(By.xpath("//*[contains(text(),'Hello. Sign in')]"));
		loginBtn.click();
	}
}
