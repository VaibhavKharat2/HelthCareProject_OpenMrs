package OpenMrsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenMrs3_RegisterPetientPage {

	@FindBy(xpath = "//input[@name='givenName']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='familyName']")
	private WebElement lastName;

	@FindBy(id = "next-button")
	private WebElement nextButton;

	@FindBy(id = "gender-field")
	private WebElement patientGender; // Male

	@FindBy(id = "next-button")
	private WebElement nextButton2;

	@FindBy(xpath = "//input[@id='birthdateDay-field']")
	private WebElement birthDayFields;

	@FindBy(xpath = "//select[@id='birthdateMonth-field']")
	private WebElement birthMonthFields; // January

	@FindBy(xpath = "//input[@id='birthdateYear-field']")
	private WebElement birthYearFields;

	@FindBy(id = "next-button")
	private WebElement nextButton3;

	@FindBy(id = "address1")
	private WebElement addressFields;

	@FindBy(id = "next-button")
	private WebElement nextButton4;

	@FindBy(id = "next-button")
	private WebElement nextButton5;

	@FindBy(id = "next-button")
	private WebElement nextButton6;

	@FindBy(xpath = "//input[@id='submit']")
	private WebElement confirmButton;

	public OpenMrs3_RegisterPetientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterPetientName(String fname, String lname) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		nextButton.click();
	}

	public void selectGenderOfPatient(String gender) {
		Select s = new Select(patientGender);
		s.selectByVisibleText(gender);
		nextButton2.click();
	}

	public void enterBirthDetails(String day, String month, String year) {
		birthDayFields.sendKeys(day);

		Select s = new Select(birthMonthFields);
		s.selectByVisibleText(month);

		birthYearFields.sendKeys(year);
		nextButton3.click();
	}

	public void enterAddress(String address) throws InterruptedException {
		addressFields.sendKeys(address);
		nextButton4.click();
		Thread.sleep(400);
		nextButton5.click();
		Thread.sleep(400);
		nextButton6.click();
		Thread.sleep(400);
	}

	public void clickOnConfirmButton() {
		confirmButton.click();
	}

}
