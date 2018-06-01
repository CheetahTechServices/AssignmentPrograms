package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant
{
	public WebDriver driver;
	static {
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	@BeforeMethod
	public void openApplication()
	{
		//driver=new ChromeDriver();
		driver=new FirefoxDriver();
		driver.get(Lib.getPropertyValue("URL"));
		String ito = Lib.getPropertyValue("ImplicitTimeout");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ito), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult tr)
	{
		if(ITestResult.FAILURE!=tr.getStatus())
		{
			String methodName = tr.getName();
			Lib.getScreenshot(driver, methodName);
		}
		driver.close();
	}
}
