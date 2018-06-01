package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.HomePage;
import pompages.LoginPage;

public class VerifyProductVersion extends BaseTest 
{
	@Test
	public void verifyVersion() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Lib.getCellValue("ValidLogin", 1, 0));
		lp.setPassword(Lib.getCellValue("ValidLogin", 1, 1));
		lp.clicklogin();
		
		Thread.sleep(5000);
		String title=Lib.getPropertyValue("HomeText");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(title));
		hp.clickAboutBTN();
		hp.clickAboutLink();
		String act = hp.getVersionText();
		System.out.println(act);
		hp.closePopUp();
		hp.clickLogout();
		String exp = Lib.getPropertyValue("VERSION");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(act,exp);
		sa.assertAll();
	}
}




