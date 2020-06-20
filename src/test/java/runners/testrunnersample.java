package runners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;


//@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/positive/cucumber.json", "pretty", "html:target/positive/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
features = "src/test/resources/featuresample", glue = "steps",
monochrome = true
)

public class testrunnersample extends AbstractTestNGCucumberTests{
		
	  @BeforeClass public static void setup() { 
		  // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file bydefault. 
	  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss");
	  Date curDate = new Date(); 
	  String strDate = sdf.format(curDate); 
	  String fileName = System.getProperty("user.dir")+"\\target\\Extent_Reports\\" + strDate+".html";
	  File newFile = new File(fileName);
	  ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);
	  //static report name
	  
	  // Loads the extent config xml to customize on the report.
	  ExtentCucumberFormatter.loadConfig(new
	  File("src/test/resources/extent.properties"));
	  
	  // User can add the system information as follows
	  ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
	  ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
	  ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");
	  
	  // Also you can add system information using a hash map
	  Map systemInfo = new HashMap();
	  systemInfo.put("Cucumber version", "v1.2.3");
	  systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
	  ExtentCucumberFormatter.addSystemInfo(systemInfo); }
	 
	
}
