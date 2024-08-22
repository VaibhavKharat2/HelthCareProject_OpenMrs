package OpenMrsBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenMrs_BaseClass {

	public static WebDriver driver;

	public void openBrowser() {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}

	public void browserClose() {
		driver.close();
	}
}
