package parallel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(features = { "@rerun/failedrerun.txt" }, glue = { "parallel"}, plugin = {
		"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		//"timeline:test-output-thread/",
		"rerun:rerun/failedrerun.txt"
		}, monochrome = true

)
public class FailedRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
