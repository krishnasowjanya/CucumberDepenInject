package steps;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.SeleniumDriver;


public class stepdef {

	//WebDriver driver=SeleniumDriver.getDriver();

	public WebDriverWait wait;
	public Scenario scenario = null;
	public Properties Pro;
		
	private common.sharedatastep sharedata;
		public stepdef(common.sharedatastep sharedata) {
		
		this.sharedata=sharedata;
		}
	
		 @Before(order=0)
		  public void method1()throws Exception
		  {
		     // this.S=S;
		  	Pro=new Properties();
		  	FileInputStream fip= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\object.properties");
		  	Pro.load(fip);
		  }	
	
		 
				// Code for Launching the Browser and URL

	@Given("^Browser is opened and Maximized$")
	public void browser_is_opened_and_Maximized()  {
		
		System.out.println("browser is opened and maximized");
		
			
}
	
	@Then("^Open Application URL$")
	public void open_Application_URL() throws Throwable {
		//<List<String>> data =table.raw();
		SeleniumDriver.getDriver().get(Pro.getProperty("NRA_BackOffice_URL"));	
		//SeleniumDriver.getDriver().get("https://google.com");
		Thread.sleep(3000);
		
		//SeleniumSeleniumDriver.getDriver().getSeleniumDriver.getDriver()().get("www.google.com");
        WebDriverWait wait1=new WebDriverWait(SeleniumDriver.getDriver(),60);
     	wait1.until(ExpectedConditions.elementToBeClickable(SeleniumDriver.getDriver().findElement(By.id(Pro.getProperty("BackOffice_UserName_ID")))));
   
	    }		
//Code for Login web page
    @When("^Enter the username \"(.*)\" and password \"(.*)\"$")			
    public void enter_the_Username_and_Password(String username,String password) throws Throwable 							
    {	
    	
       SeleniumDriver.getDriver().findElement(By.id(Pro.getProperty("BackOffice_UserName_ID"))).sendKeys(username);					
       SeleniumDriver.getDriver().findElement(By.id(Pro.getProperty("BackOffice_Password_ID"))).sendKeys(password);					
       sharedata.usernm=username;
    }
    

    @Then("^click on login$")					
    public void	click_on_login() throws Throwable 							
    {		
       SeleniumDriver.getDriver().findElement(By.id(Pro.getProperty("BackOffice_Login_ID"))).click();
       //SeleniumDriver.getDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
       Thread.sleep(5000);
           }
  // Code for Logout button of the application and verifying the Title of the page
 @Then("^Logot the application$")
 public void	click_on_logout() throws Throwable 
 {
	 SeleniumDriver.getDriver().findElement(By.id(Pro.getProperty("Logoutbutton_ID"))).click();	
     
	   	String ActualTitle=SeleniumDriver.getDriver().getTitle();
	   	if(ActualTitle.contains(Pro.getProperty("title")))
	   	{
	   		
	   		
	        Assert.assertEquals("Trips+"
	        		+ "", ActualTitle);
	        Assert.assertTrue(true);
	   	}
	   	else 
	   	{
	   		
	   		Assert.fail();
	    }	
 }
}
 
    //------ Register Individual Taxpayer Submit Scenario-------

