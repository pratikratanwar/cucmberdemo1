package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Steps {
	WebDriver driver;

	@Given("the user is on the nopCommerce login page")
	public void the_user_is_on_the_nopCommerce_login_page() {
		
		driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
				
		
		
	}
@When("the user enters valid credentials\\(username: {string}, password: {string}")
public void the_user_enters_valid_credentials_username_password (String email, String pwd){
	
driver.findElement(By.xpath(" //input[@id='Email']" )).sendKeys(email);
driver.findElement(By.xpath(" //input[@id='Email']")).sendKeys(pwd);
}
	
@When("the user clicks on the Login button")
public void the_user_clicks_on_the_Login_button(){
	
	driver.findElement(By.xpath(" //button[normalize-space()='Log in']")).click();
}

@Then("the user should be redirected to the My Account page")
public void the_user_should_be_redirected_to_the_My_Account_page() {
boolean status=driver.findElement(By.xpath(""))	.isDisplayed();
Assert.assertEquals(status, true);
}

@Then("the user should see a welcome message")
public void the_user_should_see_a_welcome_message() {
	
	boolean welcomestatus= driver.findElement(By.xpath(null)).isDisplayed();
	Assert.assertEquals(welcomestatus, true);
	driver.quit();
}











	
	
	
	
	
	
	
	
	
	
}
