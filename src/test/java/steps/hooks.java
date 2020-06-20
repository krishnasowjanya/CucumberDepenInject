package steps;

import java.util.Properties;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.SeleniumDriver;


public class hooks {
	
	
	  //public WebDriver driver; //WebDriver driver=SeleniumDriver.getDriver();
	  public Scenario scenario = null; 
	  public Properties Pro;
	  
	  
	  
	  
	  @Before(order=1) public static void setU() {
	  System.out.println("Before class started");
	  SeleniumDriver.setUpDriver();
	  System.out.println("driver initiated"); }
	  
	/*
	 * @After (order=2) public void afterClass(Scenario scenario) throws
	 * InterruptedException, IOException {
	 * 
	 * //if (scenario.isFailed()) { // try {
	 * 
	 * byte[] screenshot =
	 * ((TakesScreenshot)SeleniumDriver.getDriver()).getScreenshotAs(OutputType.
	 * BYTES); // System.out.println(scenario.getName()); scenario.embed(screenshot,
	 * "image/png");
	 * 
	 * // } catch (WebDriverException somePlatformsDontSupportScreenshots) { //
	 * System.err.println(somePlatformsDontSupportScreenshots.getMessage()); } // }
	 * }
	 */
	  
	  
		/*
		 * @After (order=1) public void saveScreenshot(Scenario scenario) {
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss"); Date
		 * curDate = new Date(); String strDate = sdf.format(curDate); File
		 * screenshot_with_scenario_name = ((TakesScreenshot)
		 * SeleniumDriver.getDriver()).getScreenshotAs(OutputType.FILE); File
		 * destPath=new File("./target/Extent_Reports/Screenshots/" + scenario.getName()
		 * + strDate + ".png"); try { FileUtils.copyFile(screenshot_with_scenario_name,
		 * destPath); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */ 
	  
	  
	  @After(order = 0) 
	  public void AfterSteps() {
		  SeleniumDriver.tearDown();
		  }
	 
	
	@Before(order=1)
	public void beforeScenario(Scenario scenario) {		
		System.out.println("Started execution for the scenario : " + scenario.getName());
	}
	
		
	@After(order=1)
	public void AfterScenario(Scenario scenario) {
		System.out.println("Completed execution for the scenario :" + scenario.getName());
	}

}
