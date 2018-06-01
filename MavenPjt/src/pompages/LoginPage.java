package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//Declare
	
	@FindBy(name="username")
	WebElement userNameTB;
	
	@FindBy(name="pwd")
	WebElement passwordTB;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement LoginBTN;
	
	@FindBy(xpath="//span[@class='errormsg']")
	WebElement errorMsg;
	//Initialize
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilize
	public void setUserName(String usr)
	{
		userNameTB.sendKeys(usr);
	}
	
	public void setPassword(String pwd)
	{
		passwordTB.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		LoginBTN.click();
	}
	
	public String getErrorMessage()
	{
		return errorMsg.getText();
	}
}
