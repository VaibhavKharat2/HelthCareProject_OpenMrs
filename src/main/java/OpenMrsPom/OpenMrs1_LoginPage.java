package OpenMrsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMrs1_LoginPage {

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement passWord;

	@FindBy(xpath = "//ul[@id='sessionLocation']//li[6]")
	private WebElement location;

	@FindBy(id = "loginButton")
	private WebElement loginButton;

	public OpenMrs1_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterLoginCrediantials(String id, String pass) {
		userName.sendKeys(id);
		passWord.sendKeys(pass);
	}

	public void selectLocation() {
		location.click();
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

}
