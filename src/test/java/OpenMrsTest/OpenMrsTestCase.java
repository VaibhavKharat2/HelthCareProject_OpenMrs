package OpenMrsTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import OpenMrsBase.OpenMrs_BaseClass;
import OpenMrsPom.OpenMrs1_LoginPage;
import OpenMrsPom.OpenMrs2_HomePage;
import OpenMrsPom.OpenMrs3_RegisterPetientPage;
import OpenMrsPom.OpenMrs4_PetientDetailsPage;
import OpenMrsPom.OpenMrs5_AdminRegistrationDeskPage;
import OpenMrs_Utility.Utility;

//@Listeners(OpenMrs_Utility.Listener.class)
public class OpenMrsTestCase extends OpenMrs_BaseClass {

	OpenMrs1_LoginPage loginPage;
	OpenMrs2_HomePage homePage;
	OpenMrs3_RegisterPetientPage petientRegister;
	OpenMrs4_PetientDetailsPage petientDetails;
	OpenMrs5_AdminRegistrationDeskPage adminDesk;
	String petientId;
	String petientName;
	String massage = "Showing 1 to 1 of 1 entries";

	public static Logger logger;

	@BeforeTest
	public void lounchBrowser() {

		logger = logger.getLogger("OpenMrsTest");
		PropertyConfigurator.configure("Log4j.properties");

		openBrowser();
		logger.info("Opening the Browser");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		loginPage = new OpenMrs1_LoginPage(driver);
		homePage = new OpenMrs2_HomePage(driver);
		petientRegister = new OpenMrs3_RegisterPetientPage(driver);
		petientDetails = new OpenMrs4_PetientDetailsPage(driver);
		adminDesk = new OpenMrs5_AdminRegistrationDeskPage(driver);
	}

	@BeforeClass
	public void preConditions() throws IOException, InterruptedException {

		loginPage.enterLoginCrediantials(Utility.getDataFromPropertyFile("UserId"),
				Utility.getDataFromPropertyFile("Password"));
		logger.warn("Entering the valid UserId & Password");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		loginPage.selectLocation();
		logger.info("Selecting the location");
		loginPage.clickOnLoginButton();
		logger.info("Clicking on the Login Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		homePage.clickOnRegisterPetientIcons();
		logger.info("Clicking on the Register Petient Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		petientRegister.enterPetientName(Utility.getDataFromPropertyFile("fName"),
				Utility.getDataFromPropertyFile("lName"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		petientRegister.selectGenderOfPatient(Utility.getDataFromPropertyFile("gender"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		petientRegister.enterBirthDetails(Utility.getDataFromPropertyFile("day"),
				Utility.getDataFromPropertyFile("month"), Utility.getDataFromPropertyFile("year"));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		petientRegister.enterAddress(Utility.getDataFromPropertyFile("address"));
		logger.warn("Entering the valid petient details");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		petientRegister.clickOnConfirmButton();
		logger.info("Clicking on the Confirm Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		petientId = petientDetails.getPetientID();
		System.out.println(petientId);
		petientName = petientDetails.getPetientName();
		System.out.println(petientDetails);
		logger.info("Getting petient details");
		petientDetails.clickOnHomeButtonIcon();
		logger.info("Clicking on the HomePage Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		adminDesk.clickOnFindPetientRecordButton();
		logger.info("Clicking on the FindRecord Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		adminDesk.searchPetientDetails(petientId);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}

	@Test
	public void OPM_TC_1_ValidatePetientName() {
		logger.warn("validate petient name in registerList");
		Assert.assertEquals(petientName, adminDesk.getPetientName(), "Petient name not matching");
		logger.info("Validating Petient name");
	}

	@Test
	public void OPM_TC_2_ValidateRegisterRecord() {
		String actualRecord = adminDesk.getRecordsDetails();
		logger.warn("validate petient records only in registerList");
		Assert.assertEquals(massage, actualRecord, "records not matching");
		logger.info("Validating actual register records");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		browserClose();
		logger.info("Closing the browser");
	}

}
