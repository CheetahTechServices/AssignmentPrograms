package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest 
{
	//enter username
	//enter password
	//click login
	//verify home page displayed
	@Test
	public void invalidLogin() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setPassword(Lib.getCellValue("InvalidLogin", 1, 0));
		lp.setPassword(Lib.getCellValue("InvalidLogin", 1, 1));
		lp.clicklogin();
		Thread.sleep(3000);
		SoftAssert sa=new SoftAssert();
		String errorMessage = lp.getErrorMessage();
		sa.assertEquals(errorMessage, Lib.getPropertyValue("ERRORMESSAGE"));
		sa.assertAll();
	}
	
}
