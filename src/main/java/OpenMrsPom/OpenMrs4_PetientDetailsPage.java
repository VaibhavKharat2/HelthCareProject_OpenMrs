package OpenMrsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMrs4_PetientDetailsPage {

	@FindBy(xpath = "//div[@class='float-sm-right']//span")
	private WebElement petientId;

	@FindBy(xpath = "//span[@class='PersonName-givenName']")
	private WebElement petientFirstName;

	@FindBy(xpath = "//span[@class='PersonName-familyName']")
	private WebElement petientLastName;

	@FindBy(xpath = "//i[contains(@class,'icon-home')]")
	private WebElement homeButton;

	public OpenMrs4_PetientDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getPetientID() {
		return petientId.getText();
	}

	public String getPetientName() {
		String name = petientFirstName.getText() + " " + petientLastName.getText();
		return name;
	}

	public void clickOnHomeButtonIcon() {
		homeButton.click();
	}

}
