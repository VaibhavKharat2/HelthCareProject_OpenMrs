package OpenMrs_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String getDataFromPropertyFile(String key) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "//PetientDetails.properties");
		Properties prop = new Properties();
		prop.load(file);
		prop.getProperty(key);
		return prop.getProperty(key);
	}

	public static void takeScreenShot(WebDriver driver, String name) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + name + timeStamp + ".jpg");
		FileHandler.copy(src, dest);
	}
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		takeScreenShot(driver, "vaibhav");
	}

}
