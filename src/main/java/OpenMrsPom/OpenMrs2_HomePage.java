package OpenMrsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMrs2_HomePage {

	@FindBy(xpath = "(//div[@class='row'][3])//a[4]")
	private WebElement registerPetientIcon;

	public OpenMrs2_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnRegisterPetientIcons() {
		registerPetientIcon.click();
	}

}
