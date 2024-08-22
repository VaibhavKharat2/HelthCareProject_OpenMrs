package OpenMrs_Utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import OpenMrsBase.OpenMrs_BaseClass;

public class Listener extends OpenMrs_BaseClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName() + " Execution start", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName() + " Execution failed", true);

		try {
			Utility.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
