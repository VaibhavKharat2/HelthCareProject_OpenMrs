package OpenMrsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenMrs5_AdminRegistrationDeskPage {

	@FindBy(xpath = "(//a[@type='button'])[1]")
	private WebElement petientrecord;

	@FindBy(xpath = "//input[@id='patient-search']")
	private WebElement searchPetientRecord;

	@FindBy(xpath = "(//table[contains(@id,'patient')]//td)[2]")
	private WebElement petientName;

	@FindBy(xpath = "//div[@class='dataTables_info']")
	private WebElement getRecords;

	public OpenMrs5_AdminRegistrationDeskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnFindPetientRecordButton() {
		petientrecord.click();
	}

	public void searchPetientDetails(String id) {
		searchPetientRecord.sendKeys(id);
	}

	public String getPetientName() {
		return petientName.getText();
	}

	public String getRecordsDetails() {
		return getRecords.getText(); // Showing 1 to 1 of 1 entries
	}
}
