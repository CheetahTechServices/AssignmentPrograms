package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest 
{
	@Test
	public void testValidLogin() throws InterruptedException
	{
		//enter username
		//enter password
		//click login
		//verify home page displayed
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Lib.getCellValue("ValidLogin", 1, 0));
		
		lp.setPassword(Lib.getCellValue("ValidLogin", 1, 1));
		
		lp.clicklogin();
		
		Thread.sleep(5000);
		String at = driver.getTitle();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(at,Lib.getPropertyValue("HomeText"));
		sa.assertAll();
	}
}
