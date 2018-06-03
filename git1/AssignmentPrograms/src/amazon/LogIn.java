package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogIn {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		WebElement loginBtn = driver.findElement(By.xpath("//*[contains(text(),'Hello. Sign in')]"));
		loginBtn.click();
		driver.findElement(By.id("ap_email")).sendKeys("ananthsrg@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("ananth");
		driver.findElement(By.id("signInSubmit")).click();

	}

}
