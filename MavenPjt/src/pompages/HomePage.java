package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath="//span[text()='Help & Support']")
	WebElement helpBTN;
	
	@FindBy(xpath="//div[contains(text(),'About actiTIME')]")
	WebElement aboutLink;
	
	@FindBy(xpath="//td[contains(text(),'Auto-installation package')]")
	WebElement version;
	
	@FindBy(xpath="//img[@class='close']")
	WebElement closePopUp;
	
	@FindBy(id="logoutLink")
	WebElement logoutBtn;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickAboutBTN()
	{
		helpBTN.click();
	}
	
	public void clickAboutLink()
	{
		aboutLink.click();
	}
	
	public String getVersionText()
	{
		return version.getText();
	}
	
	public void clickLogout()
	{
		logoutBtn.click();
	}
	
	public void closePopUp()
	{
		closePopUp.click();
	}
}

